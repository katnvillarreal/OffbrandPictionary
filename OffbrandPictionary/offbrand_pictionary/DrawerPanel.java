package offbrand_pictionary;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.image.BufferedImage;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;

public class DrawerPanel extends JPanel{
	// Private Data Members
	private JLabel lblWord;
	private BufferedImage img;
	private PaintPanel color;
	
	// Getters
	public String getWord() { return lblWord.getText(); }
	// Setters
	public void setWord(String word) { lblWord.setText(word); }
	public void setCanvas() { color.setBack(); }
	// Constructor
	public DrawerPanel(DrawerControl dc, PaintPanel canvas) {
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
		color = canvas;
		panel_1.add(color);
		panel.add(panel_1);
		
		JButton btnSizeUp = new JButton("Size ++");
		btnSizeUp.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSizeUp.setBounds(20, 325, 67, 21);
		btnSizeUp.addActionListener(dc);
		panel.add(btnSizeUp);
		
		JButton btnSizeDown = new JButton("Size --");
		btnSizeDown.setBounds(90, 325, 67, 21);
		btnSizeDown.addActionListener(dc);
		panel.add(btnSizeDown);
		
		JButton btnBlack = new JButton("Black");
		btnBlack.setBounds(160, 325, 67, 21);
		btnBlack.addActionListener(dc);
		panel.add(btnBlack);
		
		JButton btnRed = new JButton("Red");
		btnRed.setBounds(237, 325, 60, 21);
		btnRed.addActionListener(dc);
		panel.add(btnRed);
		
		JButton btnGreen = new JButton("Green");
		btnGreen.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGreen.setBounds(307, 325, 60, 21);
		btnGreen.addActionListener(dc);
		panel.add(btnGreen);
		
		JButton btnBlue = new JButton("Blue");
		btnBlue.setBounds(377, 325, 60, 21);
		btnBlue.addActionListener(dc);
		panel.add(btnBlue);
		
		JLabel lblYourWord = new JLabel("Your Word:");
		lblYourWord.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYourWord.setBounds(459, 27, 116, 25);
		panel.add(lblYourWord);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(448, 62, 137, 2);
		panel.add(separator);
		
		lblWord = new JLabel("");
		lblWord.setBounds(459, 73, 88, 13);
		panel.add(lblWord);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(20, 10, 418, 11);
		panel.add(progressBar);
	}
}
