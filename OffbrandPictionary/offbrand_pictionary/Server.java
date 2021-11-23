// Offbrand Pictionary - Server 

package offbrand_pictionary;

import java.awt.image.BufferedImage;
import java.io.IOException;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class Server extends AbstractServer {
	// Set private data variables
	private Database database;
	private int lobbycode;
	private String catChoice;
	private String currentWord;
	
	// Class Constructor
	public Server() {
		super(8300);
		this.setTimeout(500);
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
		if (arg0 instanceof BufferedImage) {
			System.out.println("Buffered Image received");
			BufferedImage img = (BufferedImage)arg0;
			
			try {arg1.sendToClient(img); }
			catch (IOException e) { e.printStackTrace(); }
		}
		// When getting a CreateAccountData object
		else if (arg0 instanceof CreateAccountData) {
			System.out.println("CreateAccountData received");
			CreateAccountData data = (CreateAccountData)arg0;
			
			Object result;
			if (database.createNewAccount(data.getUsername(), data.getPassword())) {
				result = "CreateAccountSuccessful";
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
			GenLobbyData result = new GenLobbyData(database.getWord(catChoice), lobbycode);
			
			try { arg1.sendToClient(result); }
			catch (IOException e) { return; }
		}
		// When getting a JoinLobbyData object
		else if (arg0 instanceof JoinLobbyData) {
			System.out.println("JoinLobbyData received");
			JoinLobbyData data = (JoinLobbyData)arg0;
			Object result;
			if(data.getLobbyCode()== lobbycode) {
				result = "JoinSuccess";
			}
			else { result = "JoinError"; }
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