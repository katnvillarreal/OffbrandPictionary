package offbrand_pictionary;

import java.io.Serializable;

public class JoinLobbyData implements Serializable{
	private String nickname;
	private int lobbyCode;
	
	public String getNickname() {
		return nickname;
	}
	
	public int getLobbyCode() {
		return lobbyCode;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void setLobbyCode(int lobbyCode) {
		this.lobbyCode = lobbyCode;
	}
	
	JoinLobbyData(String nickname, int lobbyCode) {
		setNickname(nickname);
		setLobbyCode(lobbyCode);
	}
	
}
