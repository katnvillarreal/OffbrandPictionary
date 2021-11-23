package offbrand_pictionary;

import java.io.Serializable;

public class WaitingRoomData implements Serializable{
	private String lobbyCode;
	
	public String getLobbyCode() {
		return lobbyCode;
	}
	public void setLobbyCode(String lobbyCode) {
		this.lobbyCode = lobbyCode;
	}
	
	WaitingRoomData(String lobbyCode){
		this.lobbyCode = lobbyCode;
	}
}
