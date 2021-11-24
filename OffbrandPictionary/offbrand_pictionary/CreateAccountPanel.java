package offbrand_pictionary;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreateAccountPanel extends JPanel{
	// Private Data Members
	private JTextField tf_Username;
	private JTextField tf_Password;
	private JTextField tf_ReenterPassword;
	private JLabel lblError;
	
	// Getters
	public String getUsername() { return tf_Username.getText(); }
	public String getPassword() { return tf_Password.getText(); }
	public String getReenteredPassword() {
		return tf_ReenterPassword.getText();
	}
	
	// Setters
	public void setUsername(String username) { this.tf_Username.setText(username); }
	public void setPassword(String password) { this.tf_Password.setText(password); }
	public void setReenteredPassword(String pass) { 
		this.tf_ReenterPassword.setText(pass);
	}
	public void setError(String error) { lblError.setText(error); }
	
	// Constructor
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
		lblCreateAccount.setBounds(150, 36, 250, 55);
		panel.add(lblCreateAccount);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(70, 122, 102, 32);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(90, 155, 82, 32);
		panel.add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-enter Password:");
		lblReenterPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReenterPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReenterPassword.setBounds(24, 193, 148, 32);
		panel.add(lblReenterPassword);
		
		tf_Username = new JTextField();
		tf_Username.setBounds(180, 122, 200, 27);
		panel.add(tf_Username);
		tf_Username.setColumns(10);
		
		tf_Password = new JTextField();
		tf_Password.setBounds(180, 160, 200, 27);
		panel.add(tf_Password);
		tf_Password.setColumns(10);
		
		tf_ReenterPassword = new JTextField();
		tf_ReenterPassword.setBounds(180, 198, 200, 27);
		panel.add(tf_ReenterPassword);
		tf_ReenterPassword.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(121, 98, 306, 13);
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
		btnSubmit.setBounds(191, 260, 170, 32);
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setBackground(Color.LIGHT_GRAY);
		btnSubmit.addActionListener(cap);
		panel.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.LIGHT_GRAY);
		btnCancel.setBounds(191, 303, 170, 32);
		btnCancel.addActionListener(cap);
		panel.add(btnCancel);
	}

}
