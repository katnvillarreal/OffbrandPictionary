package offbrand_pictionary;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class CreateAccountControl implements ActionListener{
	// Private Data Members
	private JPanel container;
	private Client client;
	
	// Constructor
	public CreateAccountControl(JPanel container, Client client) {
		this.container = container;
		this.client = client;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		// Get the name of the button clicked.
	    String command = ae.getActionCommand();

	    // If Cancel is clicked then go back to the WelcomePanel
	    if (command == "Cancel") {
	    	CreateAccountPanel createAccountPanel = (CreateAccountPanel)container.getComponent(2);
	    	createAccountPanel.setUsername("");
	    	createAccountPanel.setPassword("");
	    	createAccountPanel.setPassword("");
	    	CardLayout cardLayout = (CardLayout)container.getLayout();
	    	cardLayout.show(container, "1");
	    	try { client.sendToServer("Cancel"); } 
	    	catch (IOException e) { displayError("Error connecting to the server."); }
	    }
	    // If the submit button is clicked check if it works
	    else if (command == "Submit") {
	    	CreateAccountPanel createAccountPanel = (CreateAccountPanel)container.getComponent(2);
	    	String username = createAccountPanel.getUsername();
	    	String password = createAccountPanel.getPassword();
	    	String passwordVerify = createAccountPanel.getReenteredPassword();

	    	// Check the validity of the information locally first.
	    	if (username.equals("") || password.equals("")) {
	    		displayError("You must enter a username and password.");
	    		return;
	    	}
	    	// Make sure the passwords match
	    	else if (!password.equals(passwordVerify)) {
	    		displayError("The two passwords did not match.");
	    		return;
	    	}
	    	
	    	CreateAccountData data = new CreateAccountData(username, password, passwordVerify);
	    	try { client.sendToServer(data); } 
	    	catch (IOException e) { displayError("Error connecting to the server."); }
	    }
	}
	
	// When account creation is successful go to the GenLobbyPanel
	public void createAccountSuccess() {
		CreateAccountPanel createAccountPanel = (CreateAccountPanel)container.getComponent(2);
    	createAccountPanel.setUsername("");
    	createAccountPanel.setPassword("");
    	createAccountPanel.setPassword("");
		GenLobbyPanel genLobbyPanel = (GenLobbyPanel)container.getComponent(3);
		genLobbyPanel.setError("");
		CardLayout cardLayout = (CardLayout)container.getLayout();
		cardLayout.show(container, "4");
	}
	  
	// Display an error on CreateAccountPanel
	public void displayError(String error) {
		CreateAccountPanel createAccountPanel = (CreateAccountPanel)container.getComponent(2);
		createAccountPanel.setError(error);
	}
}
