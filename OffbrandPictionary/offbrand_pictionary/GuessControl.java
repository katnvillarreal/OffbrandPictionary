package offbrand_pictionary;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class GuessControl implements ActionListener{
	// Private Data members
	private JPanel container;
	private BufferedImage img;
	private Client client;
	
	// Constructor
	public GuessControl(JPanel container, Client client) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		
		// When guess button is pressed
		if (command == "Guess") {
			GuesserPanel guessPanel = (GuesserPanel)container.getComponent(7);
		    GuesserData data = new GuesserData(guessPanel.getWord(), guessPanel.getDrawer());
			
			if (data.getWord().equals("")) { return; }
			else { guessPanel.setWord(""); }
			
			try { client.sendToServer(data); }
		    catch (IOException e) { System.out.println("ERROR sending word to the server."); }
		}
		
	}
	
	public void setImage(BufferedImage img) {
		this.img = img;
	}
	
	public void correctWord() {
		GuesserPanel guesserPanel = (GuesserPanel)container.getComponent(7);
		guesserPanel.setError("YOU GUESSED CORRECTLY");
		guesserPanel.correctGuess();
	}
	
	public void displayError(String error) {
		GuesserPanel guesserPanel = (GuesserPanel)container.getComponent(7);
		guesserPanel.setError(error);
	}
}