package offbrand_pictionary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class CreateAccountControl implements ActionListener{
	private JPanel container;
	private Client client;
	
	public CreateAccountControl(JPanel container, Client client) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent ae) {
		
	}
}
