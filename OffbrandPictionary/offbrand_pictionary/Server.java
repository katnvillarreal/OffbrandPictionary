// Offbrand Pictionary - Server 

package offbrand_pictionary;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class Server extends AbstractServer {
	// Set private data variables
	private Database database;
	private int lobbycode, currentPlayers, numPlayers;
	private String catChoice, currentWord;
	private ArrayList<String> playerNames;
	
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
		if (arg0 instanceof BufferedImage) {
			System.out.println("Buffered Image received");
			BufferedImage img = (BufferedImage)arg0;
			
			try {arg1.sendToClient(img); }
			catch (IOException e) { e.printStackTrace(); }
		}
		// Received a string from the client
		else if (arg0 instanceof String) {
			String msg = (String)arg0;
			if (msg.equals("addPlayer")) {
				currentPlayers++;
				if (currentPlayers == numPlayers) {
					Thread[] players = this.getClientConnections();
					for(int round = 0; round < 3; round++) {
						for (int i = 0; i < players.length; i++) {
							Thread drawer = players[i];
							try { ((ConnectionToClient) drawer).sendToClient("Drawer"); } 
							catch (IOException e) {	e.printStackTrace(); }
							// Sends "Drawer" to the client that is currently in up from the array
							// Puts the Drawer panel up for the currently selected drawer
							for (int j = 0; j < players.length; j++) {
								if (j != i) {
									Thread guesser = players[j];
									try { ((ConnectionToClient) guesser).sendToClient("Guesser"); } 
									catch (IOException e) {	e.printStackTrace(); }
									// Sends "Guesser" to the clients that are going to be guessing
									// Pulls up the guesser panel for them and writes in the current drawers name
								}
							}
							try {
								Thread.sleep(60000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
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
				result = "CreateAccountSuccessful";
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
				result = "LoginSuccessful";
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
			System.out.println("GuesserData received");
			GuesserData data = (GuesserData)arg0;
			Object result;
			if(data.getWord().equals(currentWord)) {
				result = "CorrectWord";
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
}