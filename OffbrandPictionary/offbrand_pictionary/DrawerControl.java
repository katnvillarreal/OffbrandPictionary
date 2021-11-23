package offbrand_pictionary;

import java.awt.Color;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JPanel;

public class DrawerControl implements ActionListener{
	private JPanel container;
	private Client client;
	private BufferedImage img;
	private PaintPanel canvas;
	
	public DrawerControl(JPanel container, Client client, PaintPanel canvas) {
		this.container = container;
		this.client = client;
		this.canvas = canvas;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();

		if (command == "image") {
			img = (BufferedImage) ae.getSource();
			try { client.sendToServer(img); }
		    catch (IOException e) { }
		}
		else if (command == "Size ++") {
			canvas.setSize(1);
		}
		else if (command == "Size --") {
			canvas.setSize(0);
		}
		else if (command == "Black") {
			canvas.setColor(Color.BLACK);
		}
		else if (command == "Red") {
			canvas.setColor(Color.RED);
		}
		else if (command == "Green") {
			canvas.setColor(Color.GREEN);
		}
		else if (command == "Blue") {
			canvas.setColor(Color.BLUE);
		}
	}
	
	public void setWord(String word) {
		DrawerPanel drawPanel = (DrawerPanel)container.getComponent(6);
		drawPanel.setWord(word);
	}
}
