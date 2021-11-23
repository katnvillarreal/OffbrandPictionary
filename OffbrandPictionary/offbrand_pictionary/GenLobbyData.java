package offbrand_pictionary;

import java.io.Serializable;

public class GenLobbyData implements Serializable{
	private String catChoice;
	private int numPlayers;
	private int lobbyCode;
	
	public String getCat() {
	    return catChoice;
	}
	
	public int getCode() {
	    return lobbyCode;
	}
	
	public int getPlayers() {
		return numPlayers;
	}

	public void setCat(String catChoice) {
	    this.catChoice = catChoice;
	}
	
	public void setCode(int lobbyCode) {
	    this.lobbyCode = lobbyCode;
	}
	
	public void setPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public GenLobbyData(String catChoice, int lobbyCode, int numPlayers) {
		setCat(catChoice);
		setCode(lobbyCode);
		setPlayers(numPlayers);
	}
}
