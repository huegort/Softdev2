package week08Canvas.ball;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class BallDisplay extends JPanel {

	Ball ball;
	
	public BallDisplay(){
		ball = new Ball(100,50);
	}
	@Override
	public void paint(Graphics g){
		ball.draw((Graphics2D) g);
	}

}
