package offbrand_pictionary;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class CreateAccountPanel extends JPanel{
	private JTextField textField_Username;
	private JTextField textField_Password;
	private JTextField textField_ReenterPassword;
	private JLabel lblError;
	
	public String getUsername() {
		return textField_Username.getText();
	}
	
	public String getPassword() {
		return textField_Password.getText();
	}
	
	public String getReenteredPassword() {
		return textField_ReenterPassword.getText();
	}
	public void setPassword(String password) {
		this.textField_Password.setText(password);
	}
	
	public void setUsername(String username) {
		this.textField_Password.setText(username);
	}
	
	public void setError(String error) {
		lblError.setText(error);
	}
	
	public CreateAccountPanel(CreateAccountControl cap) {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(10, 10, 430, 280);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCreateAccount.setBounds(24, 34, 144, 25);
		panel.add(lblCreateAccount);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(63, 88, 62, 13);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(63, 111, 62, 13);
		panel.add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-enter Password:");
		lblReenterPassword.setBounds(24, 134, 94, 13);
		panel.add(lblReenterPassword);
		
		textField_Username = new JTextField();
		textField_Username.setBounds(118, 85, 96, 19);
		panel.add(textField_Username);
		textField_Username.setColumns(10);
		
		textField_Password = new JTextField();
		textField_Password.setBounds(118, 108, 96, 19);
		panel.add(textField_Password);
		textField_Password.setColumns(10);
		
		textField_ReenterPassword = new JTextField();
		textField_ReenterPassword.setBounds(118, 131, 96, 19);
		panel.add(textField_ReenterPassword);
		textField_ReenterPassword.setColumns(10);
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(34, 65, 230, 13);
		panel.add(lblError);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CreateAccountPanel.class.getResource("/offbrand_pictionary/Stick_man_impatient.png")));
		lblNewLabel.setBounds(197, 75, 176, 313);
		panel.add(lblNewLabel);
		
		JLabel lblHurryUp = new JLabel("Hurry Up!");
		lblHurryUp.setBounds(291, 54, 45, 13);
		panel.add(lblHurryUp);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(81, 157, 85, 21);
		btnSubmit.addActionListener(cap);
		panel.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(81, 188, 85, 21);
		panel.add(btnCancel);
	}

}
