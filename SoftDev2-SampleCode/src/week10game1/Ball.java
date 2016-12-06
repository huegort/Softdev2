package week10game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball extends Ellipse2D.Double implements Actor {
	static long totalCreated = 0;
	static Color colors[] = { Color.red, 
			Color.GREEN, 
	};

	int coolDown = GameBoard.REFRESHRATE *10;
	double vx,vy;
	double size;
	Color color;
	GameBoard gameBoard;
	long id;
	boolean baddie = false;
	
	public Ball(GameBoard gb, int cx, int cy, boolean baddie){
		this(gb,cx,cy);
		this.baddie= baddie;
		if (baddie){
			color = colors[0];
		}else{
			color = colors[1];
		}
	}

	public Ball(GameBoard gb, int cx, int cy){
		id = totalCreated++;


		Random generator = new Random(); 

		gameBoard = gb;
		size = (generator.nextInt(3)+1) *20;
		//x = generator.nextDouble() * (gameBoard.getWidth()-size);
		x = generator.nextDouble() * (400-size);
		y = cy -((float)size/2);
		this.width = size;
		this.height = size;
		//System.out.print("new Ball "+x +","+y);
		vx = generator.nextFloat()*3 - 1.5f;
		vy = generator.nextFloat()*3 - 1.5f;
		int faction = generator.nextInt(2);
		//int faction = 1;
		color = colors[faction];
		if (faction== 0){
			baddie=true;
		}
		//System.out.println("G:"+goodie);
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.drawString(""+id, (int)this.getX(), (int)this.getY());
		g.fill(this);
	}

	@Override
	public void tick(){
		x+=vx;
		y+=vy;
//System.out.println(coolDown);
		if (coolDown>0){
			coolDown--;
		}
		for (Ball ball : gameBoard.balls){
			//12/6 don't want to check against myself
			if (!this.equals(ball)){
				//12/6 check if collides with a baddie

				if (ball.intersects(this.getBounds2D())){
					if (this.baddie){
						gameBoard.toBeRemoved.add(ball);
					}
					if (ball.baddie){
						gameBoard.toBeRemoved.add(this);
					}
					if (!this.baddie && !ball.baddie){
						Ball b = new Ball(gameBoard,(int) this.getX(),(int)this.getY(), false);
						if (coolDown==0){
							gameBoard.toBeAdded.add(b);
							coolDown=GameBoard.REFRESHRATE *10;
						}
					}
				}

			}
		}// end for loop
		// bounds checking
		if (x < 0){
			vx = Math.abs(vx);
		}

		if (y < 0){
			vy = Math.abs(vy);
		}
		if (x > gameBoard.getWidth()- size){
			vx = -Math.abs(vx);
		}

		if (y > gameBoard.getHeight()- size){
			vy = -Math.abs(vy);
		}
	}

	@Override
	public int hashCode() {

		int result = 0;
		result =  (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Ball other = (Ball) obj;
		if (id != other.id)
			return false;
		return true;
	}


}
