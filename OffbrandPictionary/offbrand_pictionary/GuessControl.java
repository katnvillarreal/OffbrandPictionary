package offbrand_pictionary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GuessControl implements ActionListener{
	private JPanel container;
	private BufferedImage img;
	private Client client;
	
	public GuessControl(JPanel container, Client client) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent ae) {
		
	}
	
	public void setImage(BufferedImage img) {
		this.img = img;
	}
}