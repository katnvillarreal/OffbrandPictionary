package offbrand_pictionary;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblError;
	
	public String getUsername() {
	    return textField.getText();
	}

	public String getPassword() {
		return textField_1.getText();
	}

	public void setUsername(String user) {
		textField.setText(user);
	}

	public void setPassword(String pass) {
		textField_1.setText(pass);
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
		
		JLabel lblLogIn = new JLabel("Log in");
		lblLogIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogIn.setBounds(36, 55, 63, 25);
		panel.add(lblLogIn);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(36, 128, 63, 13);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(36, 151, 55, 13);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(87, 125, 96, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(87, 148, 96, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(36, 105, 45, 13);
		panel.add(lblError);
	}
}
