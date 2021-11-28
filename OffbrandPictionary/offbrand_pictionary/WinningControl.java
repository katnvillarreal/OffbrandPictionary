package offbrand_pictionary;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class WinningControl implements ActionListener{
	
	// Private data members
	private JPanel container;
	private Client client;

	// Constructor
	public WinningControl (JPanel container, Client client) { this.container = container; this.client = client;}

	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		// When login is pressed go to LoginPanel
		if (action.equals("Back to Start")) {
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container,  "1");
			try { client.sendToServer("Reset"); }
			catch (IOException e1) { e1.printStackTrace(); }
		}
		// When Create Account is pressed go to CreateAccountPanel
		else if (action.equals("Exit")) {
			System.exit(0);
		}
	}
	
	public void setRanking(String str) {
		WinningPanel winningPanel = (WinningPanel)container.getComponent(8);
		winningPanel.setRanking(str);
		CardLayout cardLayout = (CardLayout)container.getLayout();
		cardLayout.show(container, "9");
	}
}
