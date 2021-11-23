package offbrand_pictionary;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;

public class WaitingRoomControl implements ActionListener{
	private JPanel container;
	private Client client;
	
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
	    	WaitingRoomPanel waitingRoomPanel = (WaitingRoomPanel)container.getComponent(5);
	    	String lobbyCode = waitingRoomPanel.getLobbyCode();
	    	WaitingRoomData waitingRoomData  = new WaitingRoomData(lobbyCode);
	    	try { client.sendToServer(waitingRoomData); }
		    catch (IOException e) { System.out.println("Error sending data to server."); }
			
	    }
	    // If cancel button is pressed go back to JoinLobbyPanel
	    else if(command == "Cancel") {
	    	CardLayout cardLayout = (CardLayout)container.getLayout();
	    	cardLayout.show(container, "1");
	    }
	}
	
	public void setLobbyCode(String lobbyCode) {
		WaitingRoomPanel waitingRoomPanel = (WaitingRoomPanel)container.getComponent(5);
		waitingRoomPanel.setLobbyCode(lobbyCode);
	}
}
