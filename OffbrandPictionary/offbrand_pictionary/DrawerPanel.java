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
import javax.swing.SwingConstants;

public class DrawerPanel extends JPanel{
	// Private Data Members
	private JLabel lblWord;
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
		btnSizeUp.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnSizeUp.setBounds(20, 325, 70, 31);
		btnSizeUp.addActionListener(dc);
		panel.add(btnSizeUp);
		
		JButton btnSizeDown = new JButton("Size --");
		btnSizeDown.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnSizeDown.setBounds(92, 325, 67, 31);
		btnSizeDown.addActionListener(dc);
		panel.add(btnSizeDown);
		
		JButton btnBlack = new JButton("Black");
		btnBlack.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnBlack.setBounds(161, 325, 67, 31);
		btnBlack.addActionListener(dc);
		panel.add(btnBlack);
		
		JButton btnRed = new JButton("Red");
		btnRed.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnRed.setBounds(231, 325, 67, 31);
		btnRed.addActionListener(dc);
		panel.add(btnRed);
		
		JButton btnGreen = new JButton("Green");
		btnGreen.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnGreen.setBounds(301, 325, 67, 31);
		btnGreen.addActionListener(dc);
		panel.add(btnGreen);
		
		JButton btnBlue = new JButton("Eraser");
		btnBlue.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnBlue.setBounds(371, 325, 67, 31);
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
		lblWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblWord.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWord.setBounds(459, 73, 126, 25);
		panel.add(lblWord);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(20, 10, 418, 11);
		panel.add(progressBar);
	}
}
