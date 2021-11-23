package offbrand_pictionary;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PlayerGUI extends JFrame {
	
	public PlayerGUI() {
		Client client = new Client();
		client.setHost("localhost");
		client.setPort(8300);
		try {
			client.openConnection();
		} catch (IOException e) { e.printStackTrace(); }
		
		this.setTitle("Offbrand Pictionary");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CardLayout cardLayout = new CardLayout();
		JPanel container = new JPanel(cardLayout);
		
		WelcomeControl wc = new WelcomeControl(container);
		LoginControl lc = new LoginControl(container, client);
		CreateAccountControl cac = new CreateAccountControl(container, client);
	    GenLobbyControl glc = new GenLobbyControl(container, client);
	    JoinLobbyControl jlc = new JoinLobbyControl(container, client);
	    WaitingRoomControl wrc = new WaitingRoomControl(container, client);
	    DrawerControl dc = new DrawerControl(container, client);
	    GuessControl gc = new GuessControl(container, client);
		
		client.setLoginControl(lc);
		client.setDrawerControl(dc);
		client.setGuessControl(gc);
		
		JPanel view1 = new WelcomePanel(wc);
		JPanel view2 = new LoginPanel(lc);
		JPanel view3 = new CreateAccountPanel(cac);
	    JPanel view4 = new GenLobbyPanel(glc);   
	    JPanel view5 = new JoinLobbyPanel(jlc);
	    JPanel view6 = new WaitingRoomPanel(wrc);
	    JPanel view7 = new DrawerPanel(dc);
	    JPanel view8 = new GuesserPanel(gc);

		container.add(view1, "1");
		container.add(view2, "2");
		container.add(view3, "3");
	    container.add(view4, "4");
	    container.add(view5, "5");
	    container.add(view6, "6");
	    container.add(view7, "7");
	    container.add(view8, "8");
		
		cardLayout.show(container, "1");
		
		this.add(container, BorderLayout.CENTER);
		this.setSize(550, 350);
	    this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new PlayerGUI();
	}
}
