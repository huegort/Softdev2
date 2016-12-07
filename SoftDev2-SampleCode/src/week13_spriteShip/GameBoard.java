package week13_spriteShip;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GameBoard extends JPanel {
	public int LEFT=37;
	public int RIGHT=39;
	public int ACCELERATE=32;
	
	Ship ship;
	
	public GameBoard(){
		ship = new Ship(this);
		gameStart();
		
	}
	public void paint(Graphics g){
		
		Graphics2D g2 =(Graphics2D)g;
		g2.clearRect(0, 0, this.getWidth(), this.getHeight());
		ship.draw(g2);
				
	}
	public void tickAll(){
		ship.tick();
		this.repaint();
	}
	public void gameStart(){
		Thread th = new Thread(new GameRunner(this));
		th.start();
	}

}
