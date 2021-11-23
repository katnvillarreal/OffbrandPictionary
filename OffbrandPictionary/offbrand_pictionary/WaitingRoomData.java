package offbrand_pictionary;

public class WaitingRoomData {
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
