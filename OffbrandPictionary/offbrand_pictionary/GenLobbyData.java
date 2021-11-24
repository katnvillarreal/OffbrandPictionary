package offbrand_pictionary;

import java.io.Serializable;

public class GenLobbyData implements Serializable{
	// Private Data Members
	private String catChoice;
	private int lobbyCode;
	
	// Getters
	public String getCat() { return catChoice; }
	public int getCode() { return lobbyCode; }

	// Setters
	public void setCat(String catChoice) { this.catChoice = catChoice; }
	public void setCode(int lobbyCode) { this.lobbyCode = lobbyCode; }

	// Constructor
	public GenLobbyData(String catChoice, int lobbyCode) {
		setCat(catChoice);
		setCode(lobbyCode);
	}
}
