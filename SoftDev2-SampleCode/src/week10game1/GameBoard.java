package week10game1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;

public class GameBoard extends JPanel {
	public static final int REFRESHRATE= 1000/60;
	Set<Actor> actors = new HashSet<Actor>();
	Set<Ball> balls = new HashSet<Ball>();
	//12/5 this set will store the actors that we wish to remove
	Set<Actor> toBeRemoved = new HashSet<Actor>();
	Set<Ball> toBeAdded = new HashSet<Ball>();
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
		//System.out.println(actors);
		for (Actor actor : actors){
			actor.tick();
		}
		actors.addAll(toBeAdded);
		balls.addAll(toBeAdded);
		toBeAdded.clear();
		actors.removeAll(toBeRemoved);
		balls.removeAll(toBeRemoved);
		toBeRemoved.clear();
		repaint();
		
	}
	public void createBall(int x , int y){
		Ball ball = new Ball(this, x,y);
		balls.add(ball);
		actors.add(ball);
	}

}
