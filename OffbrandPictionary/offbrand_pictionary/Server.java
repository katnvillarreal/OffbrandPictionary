// Offbrand Pictionary - Server 
// adopted from Mark Smith

package offbrand_pictionary;

import java.awt.image.BufferedImage;
import java.io.IOException;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class Server extends AbstractServer {
	private Database database;
	private String lobbycode;
	private String catChoice;
	private String typeChoice;
	
	public Server() {
		super(12345);
		this.setTimeout(500);
	}

	public void setDatabase(Database database) {
		  this.database = database;
	}
	
	public void setCatChoice() {
		
	}
	
	public void serverStarted() {
		System.out.println("Server Started");
	}
	
	public void clientConnected(ConnectionToClient client) {
		System.out.println("Client connected");
	}

	public void handleMessageFromClient(Object arg0, ConnectionToClient arg1) {
		if (arg0 instanceof BufferedImage) {
			BufferedImage img = (BufferedImage)arg0;
			
			try {arg1.sendToClient(img); }
			catch (IOException e) { e.printStackTrace(); }
		}
		else if (arg0 instanceof CreateAccountData) {
			CreateAccountData data = (CreateAccountData)arg0;
			
			Object result;
			if (database.createNewAccount(data.getUsername(), data.getPassword())) {
				result = "CreateAccountSuccessful";
			}
			else { result = "ErrorUsername"; }
			
			try { arg1.sendToClient(result); }
			catch (IOException e) { return; }
		}
		else if (arg0 instanceof LoginData) {
			
		}
		else if (arg0 instanceof GenLobbyData) {
			GenLobbyData data = (GenLobbyData)arg0;
			
			catChoice = data.getCat();
			int lobbyCode = data.getCode();
			GenLobbyData result = new GenLobbyData(database.getWord(catChoice), lobbyCode);
			
			try { arg1.sendToClient(result); }
			catch (IOException e) { return; }
		}
		else if (arg0 instanceof JoinLobbyData) {
			try { arg1.sendToClient(arg0); }
			catch (IOException e) { return; }
		}
	}

	public void listeningException(Throwable exception) {
		System.out.println("Listening Exception Occurred");
	    System.out.println(exception.getMessage());
	    exception.printStackTrace();
	}
	
	public void connectionException (Throwable exception) {
		System.out.println("Connect Exception Occured\n");
		System.out.println(exception.getMessage());
		exception.printStackTrace();
	}
	
	public void connectionEstablished() {
		System.out.println("Client Connected");
	}
}