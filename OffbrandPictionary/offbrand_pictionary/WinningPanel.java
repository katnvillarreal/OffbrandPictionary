package offbrand_pictionary;

import javax.swing.*;
import java.awt.*;

public class WinningPanel extends JPanel {
	// Private data members
	private JTextPane ranking;
	
	//setter
	public void setRanking(String str) { ranking.setText(str); }
	
	public WinningPanel(WinningControl winc) {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(10, 11, 613, 382);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblFinalStandings = new JLabel("Final Standings");
		lblFinalStandings.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinalStandings.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblFinalStandings.setBounds(177, 11, 262, 75);
		panel.add(lblFinalStandings);
		
		ranking = new JTextPane();
		ranking.setBackground(new Color(143, 188, 143));
		ranking.setEditable(false);
		ranking.setFont(new Font("Monospaced", Font.BOLD, 23));
		ranking.setBounds(106, 73, 394, 256);
		panel.add(ranking);
		
		JButton btnBackToStart = new JButton("Back to Start");
		btnBackToStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBackToStart.setBounds(177, 342, 127, 29);
		btnBackToStart.addActionListener(winc);
		panel.add(btnBackToStart);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit.setBounds(314, 342, 127, 29);
		btnExit.addActionListener(winc);
		panel.add(btnExit);
		
		
	}
}