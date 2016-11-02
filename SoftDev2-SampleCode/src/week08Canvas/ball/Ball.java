package week08Canvas.ball;

import java.awt.Graphics2D;

public class Ball {
	
	float x,y;
	float vx, vy;
	
	public Ball(int x, int y){
		this.x = x;
		this.y = y;
		this.vx = 1;
		this.vy = 1;
		
	}
	public void draw(Graphics2D g2){
		g2.fillOval((int)x, (int)y, 50, 50);
		tick();
	}
	public void tick(){
		x+=vx;
		y+=vy;
	}

}
