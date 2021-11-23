package offbrand_pictionary;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class WaitingRoomPanel extends JPanel{
	private JLabel lblCode;
	private JTextArea playerNames;
	
	public String getLobbyCode() {
		return lblCode.getText();
	}
	
	public void setLobbyCode(String lobbyCode) {
		lblCode.setText(lobbyCode);;
	}
	
	public void setPlayerList(ArrayList<String> pNames) {
		for (String name : pNames) {
			playerNames.append(name + "\n");
		}
	}
	
	public WaitingRoomPanel(WaitingRoomControl wrc) {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(10, 11, 613, 382);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblLobbyCode = new JLabel("Lobby Code");
		lblLobbyCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblLobbyCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLobbyCode.setBounds(36, 24, 159, 39);
		panel.add(lblLobbyCode);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 55, 108, -5);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(25, 61, 184, 2);
		panel.add(separator_1);
		
		lblCode = new JLabel("");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCode.setBounds(25, 70, 184, 50);
		panel.add(lblCode);
		
		JButton btnReadyUp = new JButton("Ready Up");
		btnReadyUp.setForeground(Color.BLACK);
		btnReadyUp.setBackground(Color.LIGHT_GRAY);
		btnReadyUp.setBounds(25, 226, 199, 29);
		btnReadyUp.addActionListener(wrc);
		panel.add(btnReadyUp);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.LIGHT_GRAY);
		btnCancel.setBounds(25, 266, 199, 29);
		panel.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(WaitingRoomPanel.class.getResource("/offbrand_pictionary/Stick_man.png")));
		lblNewLabel.setBounds(445, 55, 168, 328);
		panel.add(lblNewLabel);
		
		playerNames = new JTextArea();
		playerNames.setFont(new Font("Monospaced", Font.PLAIN, 18));
		playerNames.setBackground(Color.LIGHT_GRAY);
		playerNames.setBounds(262, 11, 173, 344);
		playerNames.setText("");
		panel.add(playerNames);
		
		
	}
}
