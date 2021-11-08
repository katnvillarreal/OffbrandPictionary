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
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public CreateAccountData(String username, String password){
		
	}
}
