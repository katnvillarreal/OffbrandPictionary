package offbrand_pictionary;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class LoginControl implements ActionListener{
	private JPanel container;
	private Client client;
	
	public LoginControl(JPanel container, Client client) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();

		if (command == "Cancel") {
			CardLayout cardLayout = (CardLayout)container.getLayout();
		    cardLayout.show(container, "1");
		}
		else if (command == "Submit") {
			LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
		    LoginData data = new LoginData(loginPanel.getUsername(), loginPanel.getPassword());
		    
		    if (data.getUsername().equals("") || data.getPassword().equals("")) {
		        displayError("You must enter a username and password.");
		        return;
		    }

		    try { client.sendToServer(data); }
		    catch (IOException e) { displayError("Error connecting to the server."); }
		}
	}
	
	public void loginSuccess() {
		GenLobbyPanel genLobbyPanel = (GenLobbyPanel)container.getComponent(4);
		genLobbyPanel.setError("");
		CardLayout cardLayout = (CardLayout)container.getLayout();
		cardLayout.show(container, "4");
	}
	
	public void displayError(String error) {
		LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
		loginPanel.setError(error);
	}
}
