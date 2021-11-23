package offbrand_pictionary;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

class PaintPanel extends JPanel implements MouseListener, MouseMotionListener {

    private Color color = Color.BLACK;;
    private Point end = null;
	private int n = 5;
	
    private BufferedImage bufImage = null;
    
    public PaintPanel(int w, int h) {
        setPreferredSize(new Dimension(w, h));
        setBackground(Color.white);
        
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public void setSize(int p) {
        if (p == 0) {
        	n--; 
        	if (n < 1) { n = 1; }
        }
        else { n++; }
    }
    
    @Override public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        
        if (bufImage == null) {
            int w = this.getWidth();
            int h = this.getHeight();
            bufImage = (BufferedImage)this.createImage(w, h);
            Graphics2D gc = bufImage.createGraphics();
            gc.setColor(Color.WHITE);
            gc.fillRect(0, 0, w, h);
        }
        
        g2.drawImage(bufImage, null, 0, 0); 
    }
    
    public void mousePressed(MouseEvent e) {
    	end = new Point(e.getX(), e.getY());
    }
    
    public void mouseDragged(MouseEvent e) {
    	Graphics g = bufImage.getGraphics();
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(n));
		g.setColor(color);
		g2.drawLine(e.getX(), e.getY(), e.getX(), e.getY());
		
		repaint();
    }
    
    public void mouseMoved  (MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited (MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}