// Offbrand Pictionary - Server 
// adopted from Mark Smith

package offbrand_pictionary;

import java.awt.image.BufferedImage;
import java.io.IOException;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class Server extends AbstractServer {
	private Database database;
	
	public Server() {
		super(12345);
		this.setTimeout(500);
	}

	public void setDatabase(Database database) {
		  this.database = database;
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
			
			
		}
		else if (arg0 instanceof GenLobbyData) {
			GenLobbyData data = (GenLobbyData)arg0;
			
			String catChoice = data.getCat();
			String typeChoice = data.getType();
			
			// server needs to query database for categories
			// servers gets string array form database
			// server randomly generates a random number and uses it to pick a word form the string array
			// sends the word back to the client
			
			String word = "choice";
			
			try { arg1.sendToClient(word); }
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