package offbrand_pictionary;

import java.io.Serializable;

public class WaitingRoomData implements Serializable{
	// Private Data Members
	private String lobbyCode;
	// Getters
	public String getLobbyCode() { return lobbyCode; }
	// Setters
	public void setLobbyCode(String lobbyCode) { this.lobbyCode = lobbyCode; }
	// Constructor
	WaitingRoomData(String lobbyCode){ this.lobbyCode = lobbyCode; }
}
