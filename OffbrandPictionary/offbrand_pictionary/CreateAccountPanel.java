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
		panel.setBounds(10, 11, 613, 382);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblCreateAccount = new JLabel("Create A New Account");
		lblCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCreateAccount.setBounds(139, 36, 289, 75);
		panel.add(lblCreateAccount);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(162, 122, 102, 32);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(162, 158, 102, 32);
		panel.add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-enter Password:");
		lblReenterPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReenterPassword.setBounds(98, 195, 148, 32);
		panel.add(lblReenterPassword);
		
		textField_Username = new JTextField();
		textField_Username.setBounds(252, 122, 128, 27);
		panel.add(textField_Username);
		textField_Username.setColumns(10);
		
		textField_Password = new JTextField();
		textField_Password.setBounds(252, 160, 128, 27);
		panel.add(textField_Password);
		textField_Password.setColumns(10);
		
		textField_ReenterPassword = new JTextField();
		textField_ReenterPassword.setBounds(252, 198, 128, 27);
		panel.add(textField_ReenterPassword);
		textField_ReenterPassword.setColumns(10);
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(34, 65, 230, 13);
		panel.add(lblError);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CreateAccountPanel.class.getResource("/offbrand_pictionary/Stick_man_impatient.png")));
		lblNewLabel.setBounds(389, 69, 176, 313);
		panel.add(lblNewLabel);
		
		JLabel lblHurryUp = new JLabel("Hurry Up!");
		lblHurryUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHurryUp.setBounds(470, 26, 102, 44);
		panel.add(lblHurryUp);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(186, 260, 194, 32);
		btnSubmit.addActionListener(cap);
		panel.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(186, 303, 194, 21);
		panel.add(btnCancel);
	}

}
