package offbrand_pictionary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
			
		    // if empty don't send anything to the server
			if (data.getWord().equals("")) { return; }
			// if there is words, empty out the textbox
			else { guessPanel.setWord(""); }
			
			try { client.sendToServer(data); }
		    catch (IOException e) { guessPanel.setError("Error sending guess to server"); }
		}
	}
	
	// Set the image gotten from the server to the image on the guesser panel
	public void setImage(BufferedImage img) { this.img = img; }
	
	// When the correct word is guessed alert the player and make the textbox uneditable
	public void correctWord() {
		GuesserPanel guesserPanel = (GuesserPanel)container.getComponent(7);
		guesserPanel.setError("YOU GUESSED CORRECTLY");
		guesserPanel.correctGuess();
	}
	
	// Display an error on the panel when incorrectly guessed
	public void displayError(String error) {
		GuesserPanel guesserPanel = (GuesserPanel)container.getComponent(7);
		guesserPanel.setError(error);
	}
}