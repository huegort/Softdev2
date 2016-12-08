package week13_spriteShip;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GameJFrame extends JFrame {
	GameBoard gameBoard;
	
	public GameJFrame(){
		super();
		initUI();
		placeComponents();
		bindListeners();
	}

	private void initUI() {
		gameBoard = new GameBoard();
		this.setTitle("game");
		this.setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// TODO Auto-generated method stub
		
	}

	private void placeComponents() {
		this.getContentPane().add(gameBoard);
		
	}

	private void bindListeners() {
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				onKey(arg0, true);
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				onKey(arg0,false);
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

	public void onKey(KeyEvent evt, boolean down){
		gameBoard.onKey(evt.getKeyCode(), down);
	}
	

}
