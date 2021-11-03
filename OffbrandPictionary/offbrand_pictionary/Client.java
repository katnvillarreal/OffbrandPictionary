package offbrand_pictionary;

import ocsf.client.AbstractClient;

public class Client extends AbstractClient {
	private WelcomeControl wc;
	
	public Client() {
		super("localhost",8300);
	}
	
	protected void handleMessageFromServer(Object arg0) {
		
	}
}