package offbrand_pictionary;

import java.io.Serializable;

public class GenLobbyData implements Serializable{
	private String catChoice;
	private String typeChoice;
	private int lobbyCode;
	
	public String getCat() {
	    return catChoice;
	}
	
	public int getCode() {
	    return lobbyCode;
	}

	public void setCat(String catChoice) {
	    this.catChoice = catChoice;
	}
	
	public void setCode(int lobbyCode) {
	    this.lobbyCode = lobbyCode;
	}

	public GenLobbyData(String catChoice, int lobbyCode) {
		setCat(catChoice);
		setCode(lobbyCode);
	}
}
