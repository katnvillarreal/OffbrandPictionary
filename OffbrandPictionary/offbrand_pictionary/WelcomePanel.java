package offbrand_pictionary;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class WelcomePanel extends JPanel {
	public static JButton btnLogIn;
	public static JButton btnCreateAccount;
	
	// Constructor
	public WelcomePanel(WelcomeControl wc) {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(10, 10, 613, 382);
		add(panel);
		panel.setLayout(null);
		
		btnLogIn = new JButton("Log in");
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogIn.setForeground(Color.BLACK);
		btnLogIn.setBackground(Color.LIGHT_GRAY);
		btnLogIn.setBounds(344, 279, 167, 33);
		btnLogIn.addActionListener(wc);
		panel.add(btnLogIn);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(WelcomePanel.class.getResource("/offbrand_pictionary/offbrand.png")));
		lblNewLabel_1.setBounds(296, 11, 215, 125);
		panel.add(lblNewLabel_1);
		
		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCreateAccount.setBackground(Color.LIGHT_GRAY);
		btnCreateAccount.setBounds(344, 323, 167, 33);
		btnCreateAccount.addActionListener(wc);
		panel.add(btnCreateAccount);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(WelcomePanel.class.getResource("/offbrand_pictionary/Stick_man.png")));
		lblNewLabel.setBounds(20, 73, 226, 324);
		panel.add(lblNewLabel);
		
		JLabel lblCreateALobby = new JLabel("Create A Lobby");
		lblCreateALobby.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateALobby.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCreateALobby.setBounds(344, 245, 167, 23);
		panel.add(lblCreateALobby);
		
		JButton btnJoinALobby = new JButton("Join A Lobby");
		btnJoinALobby.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnJoinALobby.setBounds(344, 159, 167, 33);
		btnJoinALobby.setForeground(Color.BLACK);
		btnJoinALobby.setBackground(Color.LIGHT_GRAY);
		btnJoinALobby.addActionListener(wc);
		panel.add(btnJoinALobby);
		
		JLabel lblOr = new JLabel("- OR -");
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblOr.setBounds(382, 203, 94, 31);
		panel.add(lblOr);
	}
	public JButton getCreActButton()
	{
		return btnCreateAccount;
	}
}
