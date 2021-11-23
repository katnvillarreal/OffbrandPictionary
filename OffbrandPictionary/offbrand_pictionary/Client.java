package offbrand_pictionary;

import java.awt.image.BufferedImage;

import ocsf.client.AbstractClient;

public class Client extends AbstractClient {
	private LoginControl lc;
	private CreateAccountControl cac;
	private GenLobbyControl glc;
	private DrawerControl dc;
	private GuessControl gc;
	private WaitingRoomControl wrc;
	private JoinLobbyControl jlc;
	
	public Client() {
		super("localhost",8300);
	}
	
	public void setLoginControl(LoginControl lc) {
		this.lc = lc;
	}
	
	public void setCreateAccountControl(CreateAccountControl cac) {
		this.cac = cac;
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
	
	public void setWaitControl(WaitingRoomControl wrc) {
		this.wrc = wrc;
	}
	
	public void setJoinLobbyControl(JoinLobbyControl jlc) {
		this.jlc = jlc;
	}
	
	protected void handleMessageFromServer(Object arg0) {
		if (arg0 instanceof String) {
			String msg = (String)arg0;
			if (msg.contains(",")) {
				String[] choice = msg.split(",");
				// client needs to send words
				dc.setWord(choice[0]);
			}
			else if (msg.equals("LoginSuccessful")) {
				lc.loginSuccess();
			}
			else if (msg.equals("LoginError")) {
				lc.displayError("The username/password are incorrect.");
			}
			else if (msg.equals("CreateAccountSuccessful")) {
				cac.createAccountSuccess();
			}
			else if (msg.equals("ErrorUsername")) {
				cac.displayError("The username is already in use.");
			}
			else if (msg.equals("JoinSuccess")) {
				jlc.JoinLobbySuccess();
			}
			else if (msg.equals("JoinError")) {
				jlc.displayError("Lobby Entered does not exist");
			}
		}
		else if (arg0 instanceof BufferedImage) {
			BufferedImage img = (BufferedImage)arg0;
			gc.setImage(img);
		}
		else if (arg0 instanceof GenLobbyData) {
			GenLobbyData data = (GenLobbyData)arg0;
			wrc.setLobbyCode(Integer.toString(data.getCode()));
			dc.setWord(data.getCat());
			glc.success();
		}
	}
}