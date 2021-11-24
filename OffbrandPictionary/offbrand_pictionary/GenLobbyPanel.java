package offbrand_pictionary;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GenLobbyPanel extends JPanel{
	// Private Data Members
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblError;
	private JComboBox comboBox;
	
	// Getters
	public ButtonGroup getGroup() { return buttonGroup; }
	public int getPlayers() {
		return Integer.parseInt((String) comboBox.getSelectedItem());
	}
	
	// Setters
	public void setGroup() { buttonGroup.clearSelection(); }
	public void setError(String error) { lblError.setText(error); }
	
	// Constructor
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
		btnStartGame.setBounds(31, 305, 155, 47);
		btnStartGame.addActionListener(glc);
		panel.add(btnStartGame);
		
		JLabel lblCategories = new JLabel("Generate Lobby");
		lblCategories.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategories.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblCategories.setBounds(62, 23, 261, 47);
		panel.add(lblCategories);
		
		JRadioButton rdbtnAnimals = new JRadioButton("Animals");
		rdbtnAnimals.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup.add(rdbtnAnimals);
		rdbtnAnimals.setBackground(new Color(143, 188, 143));
		rdbtnAnimals.setBounds(42, 154, 117, 29);
		rdbtnAnimals.setActionCommand("animal");
		panel.add(rdbtnAnimals);
		
		JRadioButton rdbtnPlaces = new JRadioButton("Places");
		rdbtnPlaces.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup.add(rdbtnPlaces);
		rdbtnPlaces.setBackground(new Color(143, 188, 143));
		rdbtnPlaces.setBounds(42, 187, 117, 29);
		rdbtnPlaces.setActionCommand("place");
		panel.add(rdbtnPlaces);
		
		JRadioButton rdbtnSports = new JRadioButton("Sports");
		rdbtnSports.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup.add(rdbtnSports);
		rdbtnSports.setBackground(new Color(143, 188, 143));
		rdbtnSports.setBounds(42, 219, 117, 33);
		rdbtnSports.setActionCommand("sport");
		panel.add(rdbtnSports);
		
		JLabel lblNumberOfPlayers = new JLabel("# of Players");
		lblNumberOfPlayers.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfPlayers.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNumberOfPlayers.setBounds(206, 94, 155, 43);
		panel.add(lblNumberOfPlayers);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.LIGHT_GRAY);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.addActionListener(glc);
		btnCancel.setBounds(217, 305, 144, 46);
		panel.add(btnCancel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"3", "4", "5", "6", "7", "8"}));
		comboBox.setBounds(216, 154, 144, 22);
		comboBox.addActionListener(glc);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GenLobbyPanel.class.getResource("/offbrand_pictionary/pirate_stickman.png")));
		lblNewLabel.setBounds(347, 0, 278, 430);
		panel.add(lblNewLabel);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(79, 81, 200, 13);
		panel.add(lblError);
		
		JLabel lblNewLabel_1 = new JLabel("Word Category");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(10, 95, 176, 40);
		panel.add(lblNewLabel_1);
	}
}
