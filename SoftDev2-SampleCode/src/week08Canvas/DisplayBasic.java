package week08Canvas;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DisplayBasic extends JPanel {
	float x = 50;
	float y = 100;
	
	
	@Override
	public void paint(Graphics g){
		// Graphics2D g2 = (Graphics2D)g;
		g.setColor(Color.RED);
		
		g.fillOval((int)x, (int)y, 30, 30);
	}
	
}
