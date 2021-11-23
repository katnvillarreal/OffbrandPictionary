package offbrand_pictionary;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GenLobbyPanel extends JPanel{
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblError;
	
	public ButtonGroup getGroup() {
		return buttonGroup;
	}
	
	public void setGroup() {
		buttonGroup.clearSelection();
	}
	
	public void setError(String error) {
		lblError.setText(error);
	}
	
	public GenLobbyPanel(GenLobbyControl glc) {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(10, 11, 613, 382);
		add(panel);
		panel.setLayout(null);
		
		JButton btnStartGame = new JButton("Generate Lobby");
		btnStartGame.setForeground(Color.BLACK);
		btnStartGame.setBackground(Color.LIGHT_GRAY);
		btnStartGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnStartGame.setBounds(71, 231, 155, 47);
		btnStartGame.addActionListener(glc);
		panel.add(btnStartGame);
		
		JLabel lblCategories = new JLabel("Select a Category");
		lblCategories.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategories.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCategories.setBounds(53, 21, 224, 47);
		panel.add(lblCategories);
		
		JRadioButton rdbtnAnimals = new JRadioButton("Animals");
		rdbtnAnimals.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup.add(rdbtnAnimals);
		rdbtnAnimals.setBackground(new Color(143, 188, 143));
		rdbtnAnimals.setBounds(85, 75, 141, 29);
		rdbtnAnimals.setActionCommand("animal");
		panel.add(rdbtnAnimals);
		
		JRadioButton rdbtnPlaces = new JRadioButton("Places");
		rdbtnPlaces.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup.add(rdbtnPlaces);
		rdbtnPlaces.setBackground(new Color(143, 188, 143));
		rdbtnPlaces.setBounds(85, 108, 117, 29);
		rdbtnPlaces.setActionCommand("place");
		panel.add(rdbtnPlaces);
		
		JRadioButton rdbtnSports = new JRadioButton("Sports");
		rdbtnSports.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup.add(rdbtnSports);
		rdbtnSports.setBackground(new Color(143, 188, 143));
		rdbtnSports.setBounds(85, 140, 117, 33);
		rdbtnSports.setActionCommand("sport");
		panel.add(rdbtnSports);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GenLobbyPanel.class.getResource("/offbrand_pictionary/pirate_stickman.png")));
		lblNewLabel.setBounds(324, -2, 289, 442);
		panel.add(lblNewLabel);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(10, 21, 179, 13);
		panel.add(lblError);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.LIGHT_GRAY);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.addActionListener(glc);
		btnCancel.setBounds(71, 289, 155, 46);
		panel.add(btnCancel);
	}
}
