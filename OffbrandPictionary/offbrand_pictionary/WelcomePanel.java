package offbrand_pictionary;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomePanel extends JPanel {
	public WelcomePanel() {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(10, 10, 430, 280);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblOffbrandPictionary = new JLabel("Offbrand Pictionary");
		lblOffbrandPictionary.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblOffbrandPictionary.setBounds(10, 10, 226, 73);
		panel.add(lblOffbrandPictionary);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setBackground(new Color(0, 0, 0));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogIn.setBounds(272, 162, 111, 21);
		panel.add(btnLogIn);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBackground(new Color(0, 0, 0));
		btnCreateAccount.setBounds(272, 193, 111, 21);
		panel.add(btnCreateAccount);
	}
}
