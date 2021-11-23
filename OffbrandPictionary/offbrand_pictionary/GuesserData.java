package offbrand_pictionary;

import java.io.Serializable;

public class GuesserData implements Serializable{
	private String word;
	private String drawer;
	
	public String getWord() {
		return word;
	}
	
	public String getDrawer() {
		return drawer;
	}
}
