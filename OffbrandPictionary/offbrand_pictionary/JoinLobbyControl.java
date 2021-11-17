package offbrand_pictionary;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;

public class JoinLobbyControl implements ActionListener{
	private JPanel container;
	private Client client;
	
	public JoinLobbyControl(JPanel container, Client client) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent ae) {
		// Get the name of the button clicked.
	    String command = ae.getActionCommand();

	    // If Cancel is clicked then go back to the WelcomePanel
	    if (command == "Cancel") {
	    	CardLayout cardLayout = (CardLayout)container.getLayout();
	    	cardLayout.show(container, "1");
	    }

	    // If the submit button is clicked check if it works
	    else if (command == "Submit") {
	    	JoinLobbyPanel joinLobbyPanel = (JoinLobbyPanel)container.getComponent(5);
	    	String nickname = joinLobbyPanel.getNickname();
	    	String lobbyCode = joinLobbyPanel.getLobbyCode();
	    	
	    	// Check if username and lobbycode is entered
	    	if (nickname.equals("")||lobbyCode.equals("")) {
	    		displayError("You must enter a nickname and lobby code.");
	    		return;
	    	}
	    	try { client.sendToServer(lobbyCode); }
		    catch (IOException e) { displayError("Lobby does not exist."); }
	    }
	}
	
	// When account creation is successful go to the GenLobbyPanel
	public void JoinLobbySuccess() {
		CardLayout cardLayout = (CardLayout)container.getLayout();
		cardLayout.show(container, "6");
	}
	
	// Display an error on CreateAccountPanel
	public void displayError(String error) {
		JoinLobbyPanel joinLobbyPanel = (JoinLobbyPanel)container.getComponent(5);
		joinLobbyPanel.setError(error);
	}
}
