package offbrand_pictionary;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	
	public void setNickname(String nick) {
		textField_Nickname.setText(nick);
	}
	
	public void setLobbyCode(String code) {
		textField_LobbyCode.setText(code);
	}
	
	public void setError(String error) {
		lblError.setText(error);
	}
	
	public JoinLobbyPanel(JoinLobbyControl jlc) {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(10, 11, 613, 382);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblJoinLobby = new JLabel("");
		lblJoinLobby.setIcon(new ImageIcon(JoinLobbyPanel.class.getResource("/offbrand_pictionary/joinlobby.png")));
		lblJoinLobby.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblJoinLobby.setBounds(10, 21, 328, 51);
		panel.add(lblJoinLobby);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 83, 267, 2);
		panel.add(separator);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNickname.setBounds(21, 100, 96, 21);
		panel.add(lblNickname);
		
		JLabel lblLobbyCode = new JLabel("Lobby Code:");
		lblLobbyCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLobbyCode.setBounds(20, 119, 107, 31);
		panel.add(lblLobbyCode);
		
		textField_Nickname = new JTextField();
		textField_Nickname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Nickname.setBounds(127, 102, 122, 21);
		panel.add(textField_Nickname);
		textField_Nickname.setColumns(10);
		
		textField_LobbyCode = new JTextField();
		textField_LobbyCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_LobbyCode.setBounds(127, 126, 122, 21);
		panel.add(textField_LobbyCode);
		textField_LobbyCode.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setBackground(Color.LIGHT_GRAY);
		btnSubmit.setBounds(55, 193, 161, 38);
		btnSubmit.addActionListener(jlc);
		panel.add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(JoinLobbyPanel.class.getResource("/offbrand_pictionary/happy_stickman.png")));
		lblNewLabel.setBounds(285, 55, 354, 401);
		panel.add(lblNewLabel);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(10, 218, 142, 13);
		panel.add(lblError);
		
		JButton btnCanel = new JButton("Cancel");
		btnCanel.setForeground(Color.BLACK);
		btnCanel.setBackground(Color.LIGHT_GRAY);
		btnCanel.addActionListener(jlc);
		btnCanel.setBounds(55, 245, 161, 38);
		panel.add(btnCanel);
	}

}
