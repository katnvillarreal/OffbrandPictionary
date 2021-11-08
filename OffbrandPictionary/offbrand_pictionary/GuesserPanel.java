package offbrand_pictionary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuesserPanel extends JPanel {
	private JTextField textField_Guess;
	private JLabel lblAnswer;
	private JLabel lblSetDrawer;
	
	public String getWord() {
		return lblAnswer.getText();
	}
	
	public String getDrawer() {
		return lblSetDrawer.getText();
	}
	
	public void setWord(String word) {
		lblAnswer.setText(word);
	}
	
	public void setDrawer(String drawer) {
		lblSetDrawer.setText(drawer);
	}
	
	public GuesserPanel(GuessControl gc) {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(10, 10, 615, 382);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(20, 27, 418, 288);
		panel.add(panel_1);
		
		JTextArea textArea_log = new JTextArea();
		textArea_log.setEditable(false);
		textArea_log.setBounds(448, 32, 157, 261);
		panel.add(textArea_log);
		
		JLabel lblWord = new JLabel("");
		lblWord.setBounds(459, 73, 88, 13);
		panel.add(lblWord);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(20, 6, 418, 11);
		panel.add(progressBar);
		
		textField_Guess = new JTextField();
		textField_Guess.setBounds(448, 296, 157, 19);
		panel.add(textField_Guess);
		textField_Guess.setColumns(10);
		
		JLabel lblTheWord = new JLabel("The Word:");
		lblTheWord.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTheWord.setBounds(20, 339, 79, 19);
		panel.add(lblTheWord);
		
		lblAnswer = new JLabel("");
		lblAnswer.setBounds(95, 339, 177, 18);
		panel.add(lblAnswer);
		
		JLabel lblDrawer = new JLabel("Drawer:");
		lblDrawer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDrawer.setBounds(448, 9, 73, 13);
		panel.add(lblDrawer);
		
		lblSetDrawer = new JLabel("");
		lblSetDrawer.setBounds(503, 9, 79, 13);
		panel.add(lblSetDrawer);
		
		JButton btnGuess = new JButton("Guess");
		btnGuess.setBounds(483, 325, 85, 21);
		btnGuess.addActionListener(gc);
		panel.add(btnGuess);
	}
}
