package offbrand_pictionary;

import java.io.Serializable;

public class GuesserData implements Serializable{
	private String word;
	private String guesser;
	
	// Getters
	public String getWord() { return word; }
	public String getGuesser() { return guesser; }
	
	// Setters
	public void setWord(String word) { this.word = word; }
	public void setGuesser(String guesser) { this.guesser = guesser; }
	
	// Constructor
	public GuesserData(String word, String guesser) {
		setWord(word);
		setGuesser(guesser);
	}
}
