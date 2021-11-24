package offbrand_pictionary;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class LoginControl implements ActionListener {
	// Private Data Members
	private JPanel container;
	private Client client;
	
	// Constructor
	public LoginControl(JPanel container, Client client) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		
		// When Cancel is pressed go back to WelcomePanel and
		// clear out the text fields
		if (command == "Cancel") {
			LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
			loginPanel.setUsername("");
			loginPanel.setPassword("");
			CardLayout cardLayout = (CardLayout)container.getLayout();
		    cardLayout.show(container, "1");
		    try { client.sendToServer("Cancel"); } 
	    	catch (IOException e) { displayError("Error connecting to the server."); }
		}
		// When Login is pressed
		else if (command == "Login") {
			LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
		    LoginData data = new LoginData(loginPanel.getUsername(), loginPanel.getPassword());
		    
		    // Make sure the text fields aren't empty
		    if (data.getUsername().equals("") || data.getPassword().equals("")) {
		        displayError("You must enter a username and password.");
		        return;
		    }
		    
		    // Send data to Server
		    try { client.sendToServer(data); }
		    catch (IOException e) { 
		    	displayError("Error connecting to the server.");
		    	e.printStackTrace();
		    }
		}
	}
	
	// When login is Successful; clear out the test fields and go to the GenLobbyPanel
	public void loginSuccess() {
		LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
		loginPanel.setUsername("");
		loginPanel.setPassword("");
		GenLobbyPanel genLobbyPanel = (GenLobbyPanel)container.getComponent(3);
		genLobbyPanel.setError("");
		CardLayout cardLayout = (CardLayout)container.getLayout();
		cardLayout.show(container, "4");
	}
	
	// Display an error when logging in
	public void displayError(String error) {
		LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
		loginPanel.setError(error);
	}
}
