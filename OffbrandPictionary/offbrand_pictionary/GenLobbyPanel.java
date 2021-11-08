package offbrand_pictionary;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class GenLobbyPanel extends JPanel{
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	public GenLobbyPanel(GenLobbyControl glc) {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(10, 10, 430, 280);
		add(panel);
		panel.setLayout(null);
		
		JButton btnStartGame = new JButton("Gen lobby");
		btnStartGame.setBounds(335, 249, 85, 21);
		btnStartGame.addActionListener(glc);
		panel.add(btnStartGame);
		
		JLabel lblCategories = new JLabel("Categories");
		lblCategories.setBounds(51, 46, 90, 13);
		panel.add(lblCategories);
		
		JRadioButton rdbtnAnimals = new JRadioButton("Animals");
		buttonGroup.add(rdbtnAnimals);
		rdbtnAnimals.setBackground(new Color(143, 188, 143));
		rdbtnAnimals.setBounds(51, 65, 103, 21);
		panel.add(rdbtnAnimals);
		
		JRadioButton rdbtnPlaces = new JRadioButton("places");
		buttonGroup.add(rdbtnPlaces);
		rdbtnPlaces.setBackground(new Color(143, 188, 143));
		rdbtnPlaces.setBounds(51, 88, 103, 21);
		panel.add(rdbtnPlaces);
		
		JRadioButton rdbtnSports = new JRadioButton("Sports");
		buttonGroup.add(rdbtnSports);
		rdbtnSports.setBackground(new Color(143, 188, 143));
		rdbtnSports.setBounds(51, 111, 103, 21);
		panel.add(rdbtnSports);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(51, 167, 45, 13);
		panel.add(lblType);
		
		JRadioButton rdbtnPoints = new JRadioButton("Points");
		buttonGroup_1.add(rdbtnPoints);
		rdbtnPoints.setBackground(new Color(143, 188, 143));
		rdbtnPoints.setBounds(51, 186, 103, 21);
		panel.add(rdbtnPoints);
		
		JRadioButton rdbtnRounds = new JRadioButton("Rounds");
		buttonGroup_1.add(rdbtnRounds);
		rdbtnRounds.setBackground(new Color(143, 188, 143));
		rdbtnRounds.setBounds(51, 209, 103, 21);
		panel.add(rdbtnRounds);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GenLobbyPanel.class.getResource("/offbrand_pictionary/pirate stickman.png")));
		lblNewLabel.setBounds(106, -14, 289, 442);
		panel.add(lblNewLabel);
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(27, 253, 179, 13);
		panel.add(lblError);
	}
}
