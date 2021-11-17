package offbrand_pictionary;

public class JoinLobbyData {
	private String nickname;
	private String lobbyCode;
	
	public String getNickname() {
		return nickname;
	}
	
	public String getLobbyCode() {
		return lobbyCode;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void setLobbyCode(String lobbyCode) {
		this.lobbyCode = lobbyCode;
	}
	
	JoinLobbyData(String nickname, String lobbyCode) {
		setNickname(nickname);
		setLobbyCode(lobbyCode);
	}
	
}
