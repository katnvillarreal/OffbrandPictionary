package offbrand_pictionary;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class WelcomePanel extends JPanel {
	public WelcomePanel(WelcomeControl wc) {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(10, 10, 430, 280);
		add(panel);
		panel.setLayout(null);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setBackground(new Color(0, 0, 0));
		btnLogIn.setBounds(272, 162, 111, 21);
		btnLogIn.addActionListener(wc);
		panel.add(btnLogIn);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(WelcomePanel.class.getResource("/offbrand_pictionary/offbrand.png")));
		lblNewLabel_1.setBounds(188, 10, 215, 125);
		panel.add(lblNewLabel_1);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBackground(new Color(0, 0, 0));
		btnCreateAccount.setBounds(272, 193, 111, 21);
		btnCreateAccount.addActionListener(wc);
		panel.add(btnCreateAccount);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(WelcomePanel.class.getResource("/offbrand_pictionary/Stick_man.png")));
		lblNewLabel.setBounds(20, 73, 226, 324);
		panel.add(lblNewLabel);
	}
}
