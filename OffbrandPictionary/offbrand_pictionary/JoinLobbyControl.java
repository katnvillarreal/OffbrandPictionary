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

	    // If Cancel is clicked then go back to the Welcome Panel
	    if (command == "Cancel") {
	    	JoinLobbyPanel joinLobbyPanel = (JoinLobbyPanel)container.getComponent(4);
	    	joinLobbyPanel.setNickname("");
	    	joinLobbyPanel.setLobbyCode("");
	    	CardLayout cardLayout = (CardLayout)container.getLayout();
	    	cardLayout.show(container, "1");
	    	try { client.sendToServer("Cancel"); } 
	    	catch (IOException e) { displayError("Error connecting to the server."); }
	    }

	    // If the submit button is clicked check if it works
	    else if (command == "Submit") {
	    	JoinLobbyPanel joinLobbyPanel = (JoinLobbyPanel)container.getComponent(4);
	    	String nickname = joinLobbyPanel.getNickname();
	    	String lobbyCode = joinLobbyPanel.getLobbyCode();
	    	
	    	// Check if username and lobbycode is entered
	    	if (nickname.equals("")||lobbyCode.equals("")) {
	    		displayError("You must enter a nickname and lobby code.");
	    		return;
	    	}
	    	JoinLobbyData joinLobbyData  = new JoinLobbyData(nickname, Integer.parseInt(lobbyCode));
	    	try { client.sendToServer(joinLobbyData); }
		    catch (IOException e) { displayError("Lobby does not exist."); }
	    }
	}
	
	// When account creation is successful go to the GenLobbyPanel
	public void JoinLobbySuccess() {
		JoinLobbyPanel joinLobbyPanel = (JoinLobbyPanel)container.getComponent(4);
    	joinLobbyPanel.setNickname("");
    	joinLobbyPanel.setLobbyCode("");
		CardLayout cardLayout = (CardLayout)container.getLayout();
		cardLayout.show(container, "6");
	}
	
	// Display an error on CreateAccountPanel
	public void displayError(String error) {
		JoinLobbyPanel joinLobbyPanel = (JoinLobbyPanel)container.getComponent(4);
		joinLobbyPanel.setError(error);
	}
}
