package offbrand_pictionary;

import java.io.Serializable;

public class CreateAccountData implements Serializable{
	// Private Data Members
	private String username;
	private String password;
	private String reenteredPassword;
	
	// Getters
	public String getUsername() { return username; }
	public String getPassword() { return password; }	
	public String getRePassword() {	return reenteredPassword; }
	
	// Setters
	public void setPassword(String password) { this.password = password; }
	public void setUsername(String username) { this.username = username; }
	public void setRePassword(String reenteredPassword) { 
		this.reenteredPassword = reenteredPassword;
	}
	
	// Constructor
	public CreateAccountData(String username, String password, String reenteredPassword) {
		setPassword(password);
		setUsername(username);
		setRePassword(reenteredPassword);
	}
}
