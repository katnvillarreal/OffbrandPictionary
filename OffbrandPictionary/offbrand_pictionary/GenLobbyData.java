package offbrand_pictionary;

import java.io.Serializable;

public class GenLobbyData implements Serializable{
	// Private Data Members
	private String catChoice;
	private int numPlayers;
	private int lobbyCode;
	
	// Getters
	public String getCat() { return catChoice; }
	public int getCode() { return lobbyCode; }
	public int getPlayers() { return numPlayers; }

	// Setters
	public void setCat(String catChoice) { this.catChoice = catChoice; }
	public void setCode(int lobbyCode) { this.lobbyCode = lobbyCode; }
	public void setPlayers(int numPlayers) { this.numPlayers = numPlayers; }

	// Constructor
	public GenLobbyData(String catChoice, int lobbyCode, int numPlayers) {
		setCat(catChoice);
		setCode(lobbyCode);
		setPlayers(numPlayers);
	}
}
