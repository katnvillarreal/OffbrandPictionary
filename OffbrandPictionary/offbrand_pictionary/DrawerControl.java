package offbrand_pictionary;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JPanel;

public class DrawerControl implements ActionListener{
	private JPanel container;
	private BufferedImage img;
	
	public DrawerControl(JPanel container) {
		this.container = container;
		//this.client = client;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();

		if (command == "image") {
			img = (BufferedImage) ae.getSource();
			// try { client.sendToServer(img); }
		    // catch (IOException e) { }
		}
	}
}
