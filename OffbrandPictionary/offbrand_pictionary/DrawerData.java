package offbrand_pictionary;

import java.io.Serializable;

public class DrawerData implements Serializable{
	// Private Data Members
	private String word;
	// Getter
	public String getWord() {return word;}
	// Setter
	public void setWord(String word) {this.word = word;}
	// Constructor
	public DrawerData(String word) { setWord(word); }
}
