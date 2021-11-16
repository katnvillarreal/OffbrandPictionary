package offbrand_pictionary;

import java.awt.image.BufferedImage;

import ocsf.client.AbstractClient;

public class Client extends AbstractClient {
	private LoginControl lc;
	private GenLobbyControl glc;
	private DrawerControl dc;
	private GuessControl gc;
	
	public Client() {
		super("localhost",8300);
	}
	
	public void setLoginControl(LoginControl lc) {
		this.lc = lc;
	}
	
	public void setGenControl(GenLobbyControl glc) {
		this.glc = glc;
	}
	
	public void setDrawerControl(DrawerControl dc) {
		this.dc = dc;
	}
	
	public void setGuessControl(GuessControl gc) {
		this.gc = gc;
	}
	
	protected void handleMessageFromServer(Object arg0) {
		if (arg0 instanceof String) {
			String msg = (String)arg0;
			if (msg.contains(",")) {
				String[] choice = msg.split(",");
				// client needs to send words
				dc.setWord(choice[0]);
			}
			
		}
		else if (arg0 instanceof BufferedImage) {
			BufferedImage img = (BufferedImage)arg0;
			gc.setImage(img);
		}
	}
}