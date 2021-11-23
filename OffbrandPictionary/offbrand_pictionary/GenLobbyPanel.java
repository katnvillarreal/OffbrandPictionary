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

public class GenLobbyPanel extends JPanel{
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JLabel lblError;
	
	public ButtonGroup getGroup() {
		return buttonGroup;
	}
	
	public ButtonGroup getGroup1() {
		return buttonGroup_1;
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
		btnStartGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnStartGame.setBounds(71, 246, 155, 47);
		btnStartGame.addActionListener(glc);
		panel.add(btnStartGame);
		
		JLabel lblCategories = new JLabel("Select a Category");
		lblCategories.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategories.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCategories.setBounds(28, 21, 286, 47);
		panel.add(lblCategories);
		
		JRadioButton rdbtnAnimals = new JRadioButton("Animals");
		rdbtnAnimals.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup.add(rdbtnAnimals);
		rdbtnAnimals.setBackground(new Color(143, 188, 143));
		rdbtnAnimals.setBounds(92, 75, 141, 29);
		rdbtnAnimals.setActionCommand("animals");
		panel.add(rdbtnAnimals);
		
		JRadioButton rdbtnPlaces = new JRadioButton("Places");
		rdbtnPlaces.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup.add(rdbtnPlaces);
		rdbtnPlaces.setBackground(new Color(143, 188, 143));
		rdbtnPlaces.setBounds(92, 108, 117, 29);
		rdbtnPlaces.setActionCommand("places");
		panel.add(rdbtnPlaces);
		
		JRadioButton rdbtnSports = new JRadioButton("Sports");
		rdbtnSports.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup.add(rdbtnSports);
		rdbtnSports.setBackground(new Color(143, 188, 143));
		rdbtnSports.setBounds(92, 140, 117, 33);
		rdbtnSports.setActionCommand("sports");
		panel.add(rdbtnSports);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GenLobbyPanel.class.getResource("/offbrand_pictionary/pirate_stickman.png")));
		lblNewLabel.setBounds(324, -2, 289, 442);
		panel.add(lblNewLabel);
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(10, 21, 179, 13);
		panel.add(lblError);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(71, 314, 155, 21);
		panel.add(btnCancel);
	}
}
