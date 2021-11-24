package offbrand_pictionary;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import ocsf.client.AbstractClient;

public class Client extends AbstractClient {
	// Private Data Members
	private LoginControl lc;
	private CreateAccountControl cac;
	private GenLobbyControl glc;
	private DrawerControl dc;
	private GuessControl gc;
	private WaitingRoomControl wrc;
	private JoinLobbyControl jlc;
	private WinningControl winc;
	private String name;
	
	// Constructor
	public Client() { super("localhost",8300); }
	
	// Setters of controls
	public void setLoginControl(LoginControl lc) { this.lc = lc; }
	public void setCreateAccountControl(CreateAccountControl cac) { this.cac = cac; }
	public void setGenControl(GenLobbyControl glc) { this.glc = glc; }
	public void setDrawerControl(DrawerControl dc) { this.dc = dc; }
	public void setGuessControl(GuessControl gc) { this.gc = gc; }
	public void setWaitControl(WaitingRoomControl wrc) { this.wrc = wrc; }
	public void setJoinLobbyControl(JoinLobbyControl jlc) { this.jlc = jlc; } 
	public void setWinningControl(WinningControl winc) { this.winc = winc; }
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
		
	protected void handleMessageFromServer(Object arg0) {
		if (arg0 instanceof String) {
			String msg = (String)arg0;
			if (msg.contains(",")) {
				String[] choice = msg.split(",");
				dc.setWord(choice[0]);
			}
			//Login
			else if (msg.equals("LoginSuccessful")) { lc.loginSuccess(); }
			else if (msg.equals("LoginError")) {
				lc.displayError("The username/password are incorrect.");
			}
			//CreateAccount
			else if (msg.equals("CreateAccountSuccessful")) {
				cac.createAccountSuccess();
			}
			else if (msg.equals("ErrorUsername")) {
				cac.displayError("The username is already in use.");
			}
			//Guessing word
			else if (msg.equals("CorrectWord")) { gc.correctWord(); }
			else if (msg.equals("IncorrectWord")) { gc.displayError("Guess is Incorrect"); }
			
			// Starting the game when everyone is readied up
			else if (msg.equals("ReadiedUp")) {
				wrc.readiedUp();
			}
			else if (msg.equals("Drawer")) {
				wrc.startGameDraw();
				dc.setBackground();
			}
			else if (msg.equals("Guesser")) {
				wrc.startGameGuess();
			}
			
			//TODO: Add in the server sending back a string of the rankings of players
			// to the winning control
		}
		// Getting an image from Drawer
		else if (arg0 instanceof BufferedImage) {
			BufferedImage img = (BufferedImage)arg0;
			gc.setImage(img);
		}
		// GenLobby
		else if (arg0 instanceof GenLobbyData) {
			GenLobbyData data = (GenLobbyData)arg0;
			wrc.setLobbyCode(Integer.toString(data.getCode()));
			dc.setWord(data.getCat());
			glc.success();
		}
		// JoinLobby
		else if (arg0 instanceof JoinLobbyData) {
			JoinLobbyData data = (JoinLobbyData)arg0;
			
			if (data.getMsg().equals("JoinSuccess")) {
				wrc.setLobbyCode(Integer.toString(data.getLobbyCode()));
				jlc.JoinLobbySuccess();
			}
			else if (data.getMsg().equals("JoinError")) {
				jlc.displayError("Lobby Entered does not exist");
			}
		}
		else if (arg0 instanceof ArrayList) {
			wrc.setUserArea((ArrayList<String>)arg0);
		}
	}
}