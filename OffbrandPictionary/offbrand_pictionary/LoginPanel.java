package offbrand_pictionary;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	private JTextField textField_Username;
	private JTextField textField_Password;
	private JLabel lblError;
	
	public String getUsername() {
	    return textField_Username.getText();
	}

	public String getPassword() {
		return textField_Password.getText();
	}

	public void setUsername(String user) {
		textField_Username.setText(user);
	}

	public void setPassword(String pass) {
		textField_Password.setText(pass);
	}
	
	public void setError(String error) {
		lblError.setText(error);
	}
	
	public LoginPanel(LoginControl lc) {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(10, 10, 613, 382);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblLogIn = new JLabel("");
		lblLogIn.setIcon(new ImageIcon(LoginPanel.class.getResource("/offbrand_pictionary/Login.png")));
		lblLogIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogIn.setBounds(193, 34, 164, 41);
		panel.add(lblLogIn);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsername.setBounds(145, 105, 106, 31);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(145, 148, 106, 31);
		panel.add(lblPassword);
		
		textField_Username = new JTextField();
		textField_Username.setBounds(261, 108, 133, 31);
		panel.add(textField_Username);
		textField_Username.setColumns(10);
		
		textField_Password = new JTextField();
		textField_Password.setBounds(261, 151, 133, 31);
		panel.add(textField_Password);
		textField_Password.setColumns(10);
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(36, 105, 45, 13);
		panel.add(lblError);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LoginPanel.class.getResource("/offbrand_pictionary/Stick_man_sideway.png")));
		lblNewLabel.setBounds(435, 65, 168, 317);
		panel.add(lblNewLabel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(193, 288, 164, 31);
		btnLogin.addActionListener(lc);
		panel.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(193, 330, 164, 21);
		btnCancel.addActionListener(lc);
		panel.add(btnCancel);
	}
}
