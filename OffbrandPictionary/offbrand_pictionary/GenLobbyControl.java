package offbrand_pictionary;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class GenLobbyControl implements ActionListener{
	private JPanel container;
	
	public GenLobbyControl(JPanel container) {
		this.container = container;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		
		if (command == "Cancel") {
			
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
			
			// Need to send the data to server????
		}
	}
	
	public void displayError(String error) {
		GenLobbyPanel lobbyPanel = (GenLobbyPanel)container.getComponent(1);
		lobbyPanel.setError(error);
	}
}
