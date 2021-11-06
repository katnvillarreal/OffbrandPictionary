package offbrand_pictionary;

import ocsf.client.AbstractClient;

public class Client extends AbstractClient {
	private LoginControl lc;
	
	public Client() {
		super("localhost",8300);
	}
	
	public void setLoginControl(LoginControl lc) {
		this.lc = lc;
	}
	
	protected void handleMessageFromServer(Object arg0) {
		
	}
}