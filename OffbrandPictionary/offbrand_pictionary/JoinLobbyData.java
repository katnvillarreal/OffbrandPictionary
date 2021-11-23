package offbrand_pictionary;

import java.io.Serializable;

public class JoinLobbyData implements Serializable{
	private String nickname;
	private int lobbyCode;
	private String msg;
	
	public String getNickname() {
		return nickname;
	}
	
	public int getLobbyCode() {
		return lobbyCode;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void setLobbyCode(int lobbyCode) {
		this.lobbyCode = lobbyCode;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	JoinLobbyData(String nickname, int lobbyCode) {
		setNickname(nickname);
		setLobbyCode(lobbyCode);
	}
	
	JoinLobbyData(String nickname, int lobbyCode, String msg) {
		setNickname(nickname);
		setLobbyCode(lobbyCode);
		setMsg(msg);
	}
	
}
