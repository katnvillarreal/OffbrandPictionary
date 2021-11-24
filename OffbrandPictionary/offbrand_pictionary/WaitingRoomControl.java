package offbrand_pictionary;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class WaitingRoomControl implements ActionListener{
	// Private Data Members
	private JPanel container;
	private Client client;
	
	// Constructor
	public WaitingRoomControl(JPanel container, Client client) {
		this.container = container;
		this.client = client;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		// Get the name of the button clicked.
	    String command = ae.getActionCommand();
	    
	    // If Ready Up is pressed
	    if (command == "Ready Up") {
	    	try { client.sendToServer("addPlayer"); }
		    catch (IOException e) { System.out.println("Error sending data to server."); }
	    }
	}
	
	// Set the lobby code
	public void setLobbyCode(String lobbyCode) {
		WaitingRoomPanel waitingRoomPanel = (WaitingRoomPanel)container.getComponent(5);
		waitingRoomPanel.setLobbyCode(lobbyCode);
	}
	
	// Set what users are in the waiting room
	public void setUserArea(ArrayList<String> playerNames) {
		WaitingRoomPanel waitingRoomPanel = (WaitingRoomPanel)container.getComponent(5);
		waitingRoomPanel.setPlayerList(playerNames);
	}
}
