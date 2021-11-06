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
		
		client.setLoginControl(lc);
		
		JPanel view1 = new WelcomePanel(wc);
		JPanel view2 = new LoginPanel(lc);

		container.add(view1, "1");
		container.add(view2, "2");
		
		cardLayout.show(container, "1");
		
		this.add(container, BorderLayout.CENTER);
		this.setSize(550, 350);
	    this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new PlayerGUI();
	}
}
