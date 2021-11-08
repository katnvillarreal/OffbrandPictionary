package offbrand_pictionary;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class JoinLobbyPanel extends JPanel{
	private JTextField textField_Nickname;
	private JTextField textField_LobbyCode;
	private JLabel lblError;
	
	public String getNickname() {
		return textField_Nickname.getText();
	}
	
	public String getLobbyCode() {
		return textField_LobbyCode.getText();
	}
	
	public void setError(String error) {
		lblError.setText(error);
	}
	
	public JoinLobbyPanel(JoinLobbyControl jlc) {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(10, 10, 430, 280);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblJoinLobby = new JLabel("");
		lblJoinLobby.setIcon(new ImageIcon(JoinLobbyPanel.class.getResource("/offbrand_pictionary/joinlobby.png")));
		lblJoinLobby.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblJoinLobby.setBounds(10, 21, 280, 51);
		panel.add(lblJoinLobby);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 90, 115, 2);
		panel.add(separator);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setBounds(21, 102, 56, 13);
		panel.add(lblNickname);
		
		JLabel lblLobbyCode = new JLabel("Lobby Code:");
		lblLobbyCode.setBounds(10, 128, 67, 13);
		panel.add(lblLobbyCode);
		
		textField_Nickname = new JTextField();
		textField_Nickname.setBounds(72, 102, 96, 19);
		panel.add(textField_Nickname);
		textField_Nickname.setColumns(10);
		
		textField_LobbyCode = new JTextField();
		textField_LobbyCode.setBounds(72, 125, 96, 19);
		panel.add(textField_LobbyCode);
		textField_LobbyCode.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(51, 154, 85, 21);
		btnSubmit.addActionListener(jlc);
		panel.add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(JoinLobbyPanel.class.getResource("/offbrand_pictionary/happy_stickman.png")));
		lblNewLabel.setBounds(124, 66, 415, 401);
		panel.add(lblNewLabel);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(10, 188, 142, 13);
		panel.add(lblError);
	}
}
