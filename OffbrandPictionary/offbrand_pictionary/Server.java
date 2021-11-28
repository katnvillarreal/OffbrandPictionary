// Offbrand Pictionary - Server 

package offbrand_pictionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class Server extends AbstractServer {
	// Set private data variables
	private Database database;
	private int lobbycode, currentPlayers, numPlayers;
	private String catChoice, currentWord;
	private ArrayList<String> playerNames;
	private Random rng = new Random();
	private int numRounds = 3;
	private int turns = 0;
	private int currentRound = 1;
	private int correctGuesses = 0;
	private HashMap<String, Integer> playerPoints;
	
	// Class Constructor
	public Server() {
		super(8300);
		this.setTimeout(500);
		currentPlayers = 0;
		playerNames = new ArrayList<String>();
	}

	// Setters
	public void setDatabase(Database database) {
		this.database = database;
	}
	public void setCatChoice(String catChoice) {
		this.catChoice = catChoice;
	}
	public void setLobbyCode(int lobbyCode) {
		this.lobbycode = lobbyCode;
	}
	// Getters
	public int getLobbyCode() {return lobbycode;}
	public String getCatChoice() {return catChoice;}
	
	// Start the server
	public void serverStarted() {
		System.out.println("Server Started");
	}
	
	// Alert when a client is connected
	public void clientConnected(ConnectionToClient client) {
		System.out.println("Client connected");
	}

	// Handle message from client
	public void handleMessageFromClient(Object arg0, ConnectionToClient arg1) {
		// When getting an image from the drawer panel
		System.out.println("Message received from Client");
		// Get Image from the Drawer Panel
		if (arg0 instanceof ImageIcon) {
			System.out.println("Image received");
			ImageIcon img = (ImageIcon)arg0;
			sendToAllClients(img);
		}
		// Received a string from the client
		else if (arg0 instanceof String) {
			String msg = (String)arg0;
			if (msg.equals("addPlayer")) {
				currentPlayers++;
				if (currentPlayers == numPlayers) {
					// Populate Hashmap with players and starting points at zero
					playerPoints = new HashMap<String, Integer>();
					for (int k = 0; k < numPlayers; k++) {
						playerPoints.put(playerNames.get(k), 0);
					}
					
					// Initiates first turn
					Thread[] players = this.getClientConnections();
					int i = rng.nextInt(numPlayers);
					currentWord = database.getWord(catChoice);
					turns++;
					Thread drawer = players[i];
					DrawerData data = new DrawerData(currentWord);
					
					try { ((ConnectionToClient) drawer).sendToClient(data); } 
					catch (IOException e) {	e.printStackTrace(); }
						// Sends "Drawer" to the client that is currently in up from the array
						// Puts the Drawer panel up for the currently selected drawer
					for (int j = 0; j < players.length; j++) {
						if (j != i) {
							Thread guesser = players[j];
							try { 
								((ConnectionToClient) guesser).sendToClient("Guesser"); } 
							catch (IOException e) {	e.printStackTrace(); }
								// Sends "Guesser" to the clients that are going to be guessing
								// Pulls up the guesser panel for them and writes in the current drawers name
						}
					}
				}
				try { arg1.sendToClient("ReadiedUp"); } 
				catch (IOException e) { e.printStackTrace(); }
			}
			else if (msg.equals("Cancel")) {
				playerNames.remove(arg1.getName());
				sendToAllClients(playerNames);
			}
			else if (msg.equals("WRCancel")) {
				playerNames.remove(arg1.getName());
				currentPlayers--;
				sendToAllClients(playerNames);
			}
		}
		// When getting a CreateAccountData object
		else if (arg0 instanceof CreateAccountData) {
			System.out.println("CreateAccountData received");
			CreateAccountData data = (CreateAccountData)arg0;
			
			Object result;
			if (database.createNewAccount(data.getUsername(), data.getPassword())) {
//				result = "CreateAccountSuccessful";
				result = data;
				playerNames.add(data.getUsername());
				arg1.setName(data.getUsername());
			}
			else { result = "ErrorUsername"; }
			
			try { arg1.sendToClient(result); }
			catch (IOException e) { return; }
		}
		// When getting a LoginData object
		else if (arg0 instanceof LoginData) {
			System.out.println("LoginData received");
			LoginData data = (LoginData)arg0;
			Object result;
			if(database.verifyAccount(data.getUsername(), data.getPassword())) {
//				result = "LoginSuccessful";
				result = data;
				playerNames.add(data.getUsername());
				arg1.setName(data.getUsername());
			}
			else { result = "LoginError"; }
			
			try { arg1.sendToClient(result); }
			catch (IOException e) { return; }
		}
		// When getting a GenLobbyData object
		else if (arg0 instanceof GenLobbyData) {
			System.out.println("GenLobbyData received");
			GenLobbyData data = (GenLobbyData)arg0;
			
			catChoice = data.getCat();
			lobbycode = data.getCode();
			numPlayers = data.getNumPlayers();
			
			GenLobbyData result = new GenLobbyData(database.getWord(catChoice), lobbycode, numPlayers);
			sendToAllClients(playerNames);
			
			try { arg1.sendToClient(result); }
			catch (IOException e) { return; }
		}
		// When getting a JoinLobbyData object
		else if (arg0 instanceof JoinLobbyData) {
			System.out.println("JoinLobbyData received");
			JoinLobbyData data = (JoinLobbyData)arg0;
			
			JoinLobbyData result;
			if(data.getLobbyCode() == lobbycode) {
				result = new JoinLobbyData(data.getNickname(), data.getLobbyCode(), "JoinSuccess");
				playerNames.add(data.getNickname());
				arg1.setName(data.getNickname());
				sendToAllClients(playerNames);
			}
			else { result = new JoinLobbyData(data.getNickname(), data.getLobbyCode(), "JoinError"); }
			
			try { arg1.sendToClient(result); }
			catch (IOException e) { return; }
		}
		// When getting a GuesserData Object
		else if (arg0 instanceof GuesserData) {
			GuesserData data = (GuesserData)arg0;
			Object result;
			sendToAllClients(data);
			if(data.getWord().equals(currentWord)) {
				result = "CorrectWord";
				// Update player points
				int points = (numPlayers - 1) -correctGuesses;
				String player = arg1.getName();
				int curPoints = playerPoints.get(player) + points;
				playerPoints.put(player, curPoints);
				
				// Update guesses
				correctGuesses++;
				if(correctGuesses == numPlayers-1) {
					if (currentRound != 2) {
						turn();
						return;
					}
					else {
						String results = "";
						// Order the players from most to least points
						// Get the highest point value
						// Add to string
						// Remove from hashmap
						for(int k = 0; k < numPlayers; k++) {
							int max = -1;
							String name = "";
							for(String n : playerPoints.keySet()) {
								if(max < playerPoints.get(n)) {
									max = playerPoints.get(n);
									name = n;
								}
							}
							results += k + ". " + name + "......" + max + "\n";
							playerPoints.remove(name);
						}
						result = new WinningData(results);
						sendToAllClients(result);
						return;
					}
				}
			}
			else { result = "IncorrectWord"; }
			try { arg1.sendToClient(result); }
			catch (IOException e) { return; }
		}
	}

	// If listening exception occurs
	public void listeningException(Throwable exception) {
		System.out.println("Listening Exception Occurred");
	    System.out.println(exception.getMessage());
	    exception.printStackTrace();
	}
	
	// If connection exception occurs
	public void connectionException (Throwable exception) {
		System.out.println("Connect Exception Occured\n");
		System.out.println(exception.getMessage());
		exception.printStackTrace();
	}
	
	// Alert when connection is established
	public void connectionEstablished() {
		System.out.println("Client Connected");
	}
	
	public void turn() {
		// Other turns
		Thread[] players = this.getClientConnections();
		int i = rng.nextInt(numPlayers);
		currentWord = database.getWord(catChoice);
		Thread drawer = players[i];
		DrawerData data = new DrawerData(currentWord);
		
		try { ((ConnectionToClient) drawer).sendToClient(data); } 
		catch (IOException e) {	e.printStackTrace(); }
			// Sends "Drawer" to the client that is currently in up from the array
			// Puts the Drawer panel up for the currently selected drawer
		for (int j = 0; j < players.length; j++) {
			if (j != i) {
				Thread guesser = players[j];
				try { 
					((ConnectionToClient) guesser).sendToClient("Guesser"); } 
				catch (IOException e) {	e.printStackTrace(); }
					// Sends "Guesser" to the clients that are going to be guessing
					// Pulls up the guesser panel for them and writes in the current drawers name
			}
		}
		
		turns++;
		correctGuesses = 0;
		if (turns == numPlayers) { 
			currentRound++;
			turns = 0;
		}
//		
//		if (currentRound == numRounds) {
//			// send to client to do winning panel
//		}
	}
}