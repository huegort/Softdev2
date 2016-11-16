package week10game1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball implements Actor {
	
	float x,y,vx,vy;
	int size;
	Color color;
	GameBoard gameBoard;
	
	public Ball(GameBoard gb, int cx, int cy){
		Random generator = new Random(); 
		
		gameBoard = gb;
		size = (generator.nextInt(3)+1) *20;
		x = cx-((float)size/2);
		y = cy -((float)size/2);
		System.out.println("new Ball "+x +","+y+":"+cx+","+cy+"::"+size);
		vx = generator.nextFloat()*3 - 1.5f;
		vy = generator.nextFloat()*3 - 1.5f;
		color = Color.RED;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int)x, (int)y, size, size);
		
	}

	@Override
	public void tick(){
		x+=vx;
		y+=vy;
		
		// bounds checking
		if (x < 0){
			vx = -vx;
		}
		
		if (y < 0){
			vy = -vy;
		}
		if (x > gameBoard.getWidth()- size){
			vx = -vx;
		}
		
		if (y > gameBoard.getHeight()- size){
			vy = -vy;
		}
	}

}
