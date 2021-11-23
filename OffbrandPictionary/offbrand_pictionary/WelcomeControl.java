package offbrand_pictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeControl implements ActionListener {
	// Private data members
	private JPanel container;

	// Constructor
	public WelcomeControl (JPanel container) { this.container = container; }
	
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		// When login is pressed go to LoginPanel
		if (action.equals("Log in")) {
			LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
			loginPanel.setError("");
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container,  "2");
		}
		// When Create Account is pressed go to CreateAccountPanel
		else if (action.equals("Create Account")) {
			CreateAccountPanel createPanel = (CreateAccountPanel)container.getComponent(2);
			createPanel.setError("");
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container,  "3");
		}
		// When Join a Lobby is pressed go to JoinLobbyPanel
		else if (action.equals("Join A Lobby")) {
			JoinLobbyPanel joinPanel = (JoinLobbyPanel)container.getComponent(4);
			joinPanel.setError("");
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container,  "5");
		}
	}
}
