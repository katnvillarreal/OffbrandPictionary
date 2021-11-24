package offbrand_pictionary;

import java.io.Serializable;

public class GenLobbyData implements Serializable{
	// Private Data Members
	private String catChoice;
	private int lobbyCode;
	private int numPlayers;
	
	// Getters
	public String getCat() { return catChoice; }
	public int getCode() { return lobbyCode; }
	public int getNumPlayers() { return numPlayers; }

	// Setters
	public void setCat(String catChoice) { this.catChoice = catChoice; }
	public void setCode(int lobbyCode) { this.lobbyCode = lobbyCode; }
	public void setNumPlayers(int numPlayers) { this.numPlayers = numPlayers; }

	// Constructor
	public GenLobbyData(String catChoice, int lobbyCode, int numPlayers) {
		setCat(catChoice);
		setCode(lobbyCode);
		setNumPlayers(numPlayers);
	}
}
