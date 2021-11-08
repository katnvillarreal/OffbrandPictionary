package offbrand_pictionary;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class WaitingRoomPanel extends JPanel{
	private JLabel lblCode;
	
	public String getLobbyCode() {
		return lblCode.getText();
	}
	
	public WaitingRoomPanel(WaitingRoomControl wrc) {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(10, 10, 430, 280);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblLobbyCode = new JLabel("lobby Code");
		lblLobbyCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLobbyCode.setBounds(36, 25, 108, 25);
		panel.add(lblLobbyCode);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 55, 108, -5);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(25, 60, 119, 2);
		panel.add(separator_1);
		
		lblCode = new JLabel("");
		lblCode.setBounds(36, 70, 119, 19);
		panel.add(lblCode);
		
		JButton btnReadyUp = new JButton("Ready Up");
		btnReadyUp.setBounds(44, 229, 85, 21);
		btnReadyUp.addActionListener(wrc);
		panel.add(btnReadyUp);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(243, 41, 162, 21);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(WaitingRoomPanel.class.getResource("/offbrand_pictionary/Stick_man.png")));
		lblNewLabel.setBounds(262, 197, 168, 328);
		panel.add(lblNewLabel);
	}
}
