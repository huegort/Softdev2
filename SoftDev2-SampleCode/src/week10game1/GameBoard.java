package week10game1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GameBoard extends JPanel {
	List<Actor> actors = new ArrayList<Actor>();
	
	public GameBoard(){
		super();
		createBall(200,200);
	}
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		for (Actor actor: actors){
			actor.draw(g2);
		}
		
	}
	public void tickAll(){
		for (Actor actor : actors){
			actor.tick();
		}
		repaint();
		
	}
	public void createBall(int x , int y){
		Ball ball = new Ball(this, x,y);
		actors.add(ball);
	}

}
