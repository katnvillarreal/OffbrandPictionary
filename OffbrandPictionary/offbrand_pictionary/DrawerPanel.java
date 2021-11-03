package offbrand_pictionary;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;

public class DrawerPanel extends JPanel{
	public DrawerPanel() {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(10, 10, 615, 382);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 27, 418, 288);
		panel.add(panel_1);
		
		JButton btnSize = new JButton("Size ++");
		btnSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSize.setBounds(10, 325, 67, 21);
		panel.add(btnSize);
		
		JButton btnSize_1 = new JButton("Size --");
		btnSize_1.setBounds(80, 325, 67, 21);
		panel.add(btnSize_1);
		
		JButton btnBlack = new JButton("Black");
		btnBlack.setBounds(150, 325, 67, 21);
		panel.add(btnBlack);
		
		JButton btnRed = new JButton("Red");
		btnRed.setBounds(227, 325, 60, 21);
		panel.add(btnRed);
		
		JButton btnGreen = new JButton("Green");
		btnGreen.setBounds(297, 325, 60, 21);
		panel.add(btnGreen);
		
		JButton btnBlue = new JButton("Blue");
		btnBlue.setBounds(367, 325, 60, 21);
		panel.add(btnBlue);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(459, 171, 116, 128);
		panel.add(textArea);
		
		JLabel lblYourWord = new JLabel("Your Word:");
		lblYourWord.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYourWord.setBounds(459, 27, 116, 25);
		panel.add(lblYourWord);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(448, 62, 137, 2);
		panel.add(separator);
		
		JLabel lblWord = new JLabel("");
		lblWord.setBounds(459, 73, 88, 13);
		panel.add(lblWord);
	}
}
