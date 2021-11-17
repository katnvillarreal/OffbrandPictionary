package offbrand_pictionary;

public class CreateAccountData {
	private String username;
	private String password;
	private String reenteredPassword;
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getRePassword() {
		return reenteredPassword;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setRePassword(String reenteredPassword) {
		this.reenteredPassword = reenteredPassword;
	}
	
	public CreateAccountData(String username, String password, String reenteredPassword) {
		setPassword(password);
		setUsername(username);
		setRePassword(reenteredPassword);
	}
}
