package offbrand_pictionary;

import java.io.Serializable;

public class GuesserData implements Serializable{
	private String word;
	private String drawer;
	
	// Getters
	public String getWord() { return word; }
	public String getDrawer() { return drawer; }
	
	// Setters
	public void setWord(String word) { this.word = word; }
	public void setDrawer(String drawer) { this.drawer = drawer; }
	
	// Constructor
	public GuesserData(String word, String drawer) {
		setWord(word);
		setDrawer(drawer);
	}
}
