package offbrand_pictionary;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginPanel extends JPanel {
	private JTextField textField_Username;
	private JPasswordField password;
	private JLabel lblError;
	
	public String getUsername() {
	    return textField_Username.getText();
	}

	public String getPassword() {
		return new String(password.getPassword());
	}

	public void setUsername(String user) {
		textField_Username.setText(user);
	}

	public void setPassword(String pass) {
		password.setText(pass);
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
		lblLogIn.setBounds(193, 11, 164, 86);
		panel.add(lblLogIn);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsername.setBounds(58, 123, 106, 31);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(58, 165, 106, 31);
		panel.add(lblPassword);
		
		textField_Username = new JTextField();
		textField_Username.setBounds(174, 126, 207, 31);
		panel.add(textField_Username);
		textField_Username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(174, 169, 207, 31);
		panel.add(password);
		password.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(142, 79, 283, 33);
		panel.add(lblError);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LoginPanel.class.getResource("/offbrand_pictionary/Stick_man_sideway.png")));
		lblNewLabel.setBounds(435, 65, 168, 317);
		panel.add(lblNewLabel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(195, 237, 164, 31);
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.addActionListener(lc);
		panel.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(195, 279, 164, 31);
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.LIGHT_GRAY);
		btnCancel.addActionListener(lc);
		panel.add(btnCancel);
	}
}
