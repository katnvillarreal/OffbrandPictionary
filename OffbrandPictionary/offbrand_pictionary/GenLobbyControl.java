package offbrand_pictionary;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class GenLobbyControl implements ActionListener{
	private JPanel container;
	private Client client;
	
	public GenLobbyControl(JPanel container, Client client) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		
		if (command == "Cancel") {
			CardLayout cardLayout = (CardLayout)container.getLayout();
		    cardLayout.show(container, "1");
		}
		else if (command == "Gen lobby") {
			GenLobbyPanel lobbyPanel = (GenLobbyPanel)container.getComponent(1);
			ButtonGroup catGroup = lobbyPanel.getGroup();
			ButtonGroup typeGroup = lobbyPanel.getGroup1();
		    GenLobbyData data = new GenLobbyData(catGroup.getSelection().getActionCommand(), typeGroup.getSelection().getActionCommand());
			
			if (data.getCat() == null || data.getType() == null) {
				displayError("You must choose a category and a game type.");
		        return;
			}
			else {
				CardLayout cardLayout = (CardLayout)container.getLayout();
			    cardLayout.show(container, "6");
			}
			
			try { client.sendToServer(data); }
		    catch (IOException e) { displayError("Error connecting to the server."); }
		}
	}
	
	public void displayError(String error) {
		GenLobbyPanel lobbyPanel = (GenLobbyPanel)container.getComponent(1);
		lobbyPanel.setError(error);
	}
}
