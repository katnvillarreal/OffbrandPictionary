// Offbrand Pictionary - ChatServer 
// adopted from Mark Smith

package offbrand_pictionary;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class Server extends AbstractServer
{
	private JTextArea log;
	private JLabel status;

	// Constructor for initializing the server.
	public Server()
	{
		super(12345);
		this.setTimeout(500);
	}

	// Method that tells the user when the server has started.
	public void serverStarted()
	{
		System.out.println("Server Started");
		log.setText("Server Started\n");
		status.setText("Listening");
		status.setForeground(Color.GREEN);
	}

	// Method that displays a message from a client and sends a message back.
	public void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
	{
		if (arg0 instanceof String)
		{
			System.out.println("Client" + arg1.getId() + " " + arg0);
			log.append("Client" + arg1.getId() + " " + arg0 + "\n");
			try
			{
				arg1.sendToClient(arg0);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	// Method that handles listening exceptions by printing exception information.
	public void listeningException(Throwable exception) 
	{
		System.out.println("Listening Exception Occurred");
		System.out.println(exception.getMessage());
		log.append("\nListening Exception: " + exception.getMessage() + "\n Press Listen to Restart Server");
		status.setText("Exception Occurred when Listening");
		status.setForeground(Color.RED);
	}

	// Method that updates the server GUI when the server stops
	public void serverStopped() {
		log.append("Server Stopped Accepting New Clients - Press Listen to Start Accepting New Clients\n");
		status.setText("Stopped");
		status.setForeground(Color.RED);
	}

	// Method that updates the server GUI when the server closes
	public void serverClosed() {
		log.append("Server and all current clients are closed - Press Listen to Restart\n");
		status.setText("Closed");
		status.setForeground(Color.RED);
	}

	// Method that handles connecting clients, updating the server GUI and providing the clients their IDs
	public void clientConnected(ConnectionToClient client) {
		try {
			long clientID = client.getId();
			client.sendToClient("username:" + "client"+clientID);
			log.append("Client " + clientID +" connected\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Setters to sync up the status and log of the ServerGUI
	public void setLog(JTextArea log) {
		this.log = log;
	}

	public void setStatus(JLabel status) {	
		this.status = status;
	}
}