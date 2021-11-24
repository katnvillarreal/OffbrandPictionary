package offbrand_pictionary;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class GenLobbyControl implements ActionListener{
	// Private Data Members
	private JPanel container;
	private Client client;
	
	// Constructor
	public GenLobbyControl(JPanel container, Client client) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		
		// When Cancel is pressed go back to LoginPanel
		if (command == "Cancel") {
			GenLobbyPanel lobbyPanel = (GenLobbyPanel)container.getComponent(3);
			lobbyPanel.setGroup();
			CardLayout cardLayout = (CardLayout)container.getLayout();
		    cardLayout.show(container, "1");
		    try { client.sendToServer("Cancel"); } 
	    	catch (IOException e) { displayError("Error connecting to the server."); }
		}
		// When GenerateLobby is pressed
		else if (command == "Generate Lobby") {
			GenLobbyPanel lobbyPanel = (GenLobbyPanel)container.getComponent(3);
			ButtonGroup catGroup = lobbyPanel.getGroup();
			
			if (catGroup.getSelection() == null) {
				displayError("You must choose a category type.");
		        return;
			}
			else {
			    GenLobbyData data = new GenLobbyData(catGroup.getSelection().getActionCommand(), gen(), lobbyPanel.getPlayers());
			    try { client.sendToServer(data); }
			    catch (IOException e) { displayError("Error connecting to the server."); }

			}
		}
	}
	
	// Generate a Lobby Code
	public int gen() {
	    Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
	
	// When Lobby is successfully generated go to Waiting room
	public void success() {
		CardLayout cardLayout = (CardLayout)container.getLayout();
		cardLayout.show(container,  "6");
	}
	
	// Display error
	public void displayError(String error) {
		GenLobbyPanel lobbyPanel = (GenLobbyPanel)container.getComponent(3);
		lobbyPanel.setError(error);
	}
}
