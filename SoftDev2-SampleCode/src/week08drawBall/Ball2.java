package week08drawBall;

import java.awt.Color;
import java.awt.Graphics;

public class Ball2 {
	int xCenter;
	int yCenter;
	double x, y;
	double d;
	Color c;
	
	public Ball2(Color c){
		this.x = 0;
		this.y = 0;
		this.d=0;
		this.c = c;
	}
	public void setCenter(int x, int y){
		this.xCenter = x;
		this.yCenter = y;
		this.x = this.xCenter -(int)d;
		this.y = this.yCenter -(int)d;
	}
	public void radiusTo(int x, int y){
		double r;
		int dx = this.xCenter - x;
		int dy = this.yCenter - y;
		int sq = dx*dx + dy*dy;
		r = Math.sqrt((double)sq);
		this.x = this.xCenter -r;
		this.y = this.yCenter - r;
		this.d = r*2;
		
	}
	public void draw(Graphics g){
		g.setColor(c);
		g.fillOval((int)x, (int)y, (int)d,(int) d);
		//System.out.println("color in ball is "+ c);
	}
	public String getDetails(){
		return "X:"+(int)x+",Y:"+(int)y+",D:"+(int)d;
	}
	

}
