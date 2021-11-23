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
		panel.setBounds(10, 10, 430, 280);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblLogIn = new JLabel("");
		lblLogIn.setIcon(new ImageIcon(LoginPanel.class.getResource("/offbrand_pictionary/Login.png")));
		lblLogIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogIn.setBounds(24, 52, 164, 41);
		panel.add(lblLogIn);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(36, 128, 63, 13);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(36, 151, 55, 13);
		panel.add(lblPassword);
		
		textField_Username = new JTextField();
		textField_Username.setBounds(87, 125, 96, 19);
		panel.add(textField_Username);
		textField_Username.setColumns(10);
		
		textField_Password = new JTextField();
		textField_Password.setBounds(87, 148, 96, 19);
		panel.add(textField_Password);
		textField_Password.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(36, 105, 45, 13);
		panel.add(lblError);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LoginPanel.class.getResource("/offbrand_pictionary/Stick_man_sideway.png")));
		lblNewLabel.setBounds(221, 10, 168, 317);
		panel.add(lblNewLabel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(56, 174, 85, 21);
		btnLogin.addActionListener(lc);
		panel.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(56, 205, 85, 21);
		btnCancel.addActionListener(lc);
		panel.add(btnCancel);
	}
}
