package offbrand_pictionary;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/*******************************************************************
 * 
 * THIS IS JUST FOR TESTING THAT THE DRAW PANEL WORKS
 * IT WILL BE DELETED LATER.
 *
 */

public class TestDraw extends JFrame {
	public TestDraw() {
		this.setTitle("Offbrand Pictionary");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CardLayout cardLayout = new CardLayout();
		JPanel container = new JPanel(cardLayout);
	    DrawerControl dc = new DrawerControl(container);
	    JPanel view7 = new DrawerPanel(dc);
	    container.add(view7, "7");
		cardLayout.show(container, "1");
		this.add(container, BorderLayout.CENTER);
		this.setSize(550, 350);
	    this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestDraw();
	}
}