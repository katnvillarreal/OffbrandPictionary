package offbrand_pictionary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuesserPanel extends JPanel {
	private JTextField textField_Guess;
	private JLabel lblError;
	private JLabel picLabel;
	private JTextArea textArea_log;
	
	// Getters
	public String getWord() { return textField_Guess.getText(); }
	
	// Setters
	public void setWord(String word) { textField_Guess.setText(word); }
	public void setError(String error) { lblError.setText(error); }
	public void setEdit() {textField_Guess.setEditable(true);}
	public void appendLog(String str) { textArea_log.append(str + "\n"); }
	public void setImage(ImageIcon img) {
		if (img != null) {
			picLabel.setIcon(img);
		}
		else {
			picLabel.setIcon(null);
		}
	}
	
	// When correctly guessing make the textfield uneditable
	public void correctGuess() { textField_Guess.setEditable(false); }
	
	// Create the 
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
		picLabel = new JLabel();
		panel_1.add(picLabel);
		panel.add(panel_1);
		
		textArea_log = new JTextArea();
		textArea_log.setEditable(false);
		textArea_log.setBounds(448, 32, 157, 261);
		panel.add(textArea_log);
		
		JLabel lblWord = new JLabel("");
		lblWord.setBounds(459, 73, 88, 13);
		panel.add(lblWord);
		
		textField_Guess = new JTextField();
		textField_Guess.setBounds(448, 296, 157, 19);
		textField_Guess.setEditable(true);
		panel.add(textField_Guess);
		textField_Guess.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setBounds(448, 357, 157, 18);
		panel.add(lblError);
		
		JButton btnGuess = new JButton("Guess");
		btnGuess.setBounds(483, 325, 85, 21);
		btnGuess.addActionListener(gc);
		panel.add(btnGuess);
	}
}
