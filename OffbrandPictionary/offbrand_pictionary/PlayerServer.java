package offbrand_pictionary;

import java.io.IOException;

public class PlayerServer {
	private Server server;
	
	public PlayerServer(int port, int timeout ) {
		server = new Server();
		
		server.setPort(port);
		server.setTimeout(timeout);
		Database db = new Database();
		server.setDatabase(db);

		try { server.listen(); }
		catch (IOException e) { e.printStackTrace();  }
	}
	
	public static void main(String[] args) {
		new PlayerServer(8300, 500);
	}
}
