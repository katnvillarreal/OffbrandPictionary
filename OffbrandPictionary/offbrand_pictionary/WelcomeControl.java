package offbrand_pictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeControl implements ActionListener{
	private JPanel container;

	public WelcomeControl (JPanel container) {
		this.container = container;
	}
	
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		if (action.equals("Log in")) {
			LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
			loginPanel.setError("");
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container,  "2");
		}
		else if (action.equals("Create Account")) {
			CreateAccountPanel createPanel = (CreateAccountPanel)container.getComponent(2);
			createPanel.setError("");
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container,  "3");
		}
	}
}
