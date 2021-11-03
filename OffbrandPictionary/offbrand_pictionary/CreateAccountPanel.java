package offbrand_pictionary;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class CreateAccountPanel extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblError;
	
	public void setError(String error) {
		lblError.setText(error);
	}
	
	public CreateAccountPanel() {
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
		
		textField = new JTextField();
		textField.setBounds(118, 85, 96, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(118, 108, 96, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(118, 131, 96, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(34, 65, 230, 13);
		panel.add(lblError);
	}

}
