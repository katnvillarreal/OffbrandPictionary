package offbrand_pictionary;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	    	// TODO: Do I need to add the nickname to the dropdown??
	    	// Send to server that this client is ready
	    }
	    // If cancel button is pressed go back to JoinLobbyPanel
	    else if(command == "Cancel") {
	    	CardLayout cardLayout = (CardLayout)container.getLayout();
	    	cardLayout.show(container, "5");
	    }
	}
	
	
}
