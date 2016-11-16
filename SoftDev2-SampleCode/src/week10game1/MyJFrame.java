package week10game1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MyJFrame extends JFrame {
	GameBoard gameBoard = new GameBoard();
	
	GameRunner gameRunner;
	
	public MyJFrame(){
		initUI();
		placeComponents();
		bindListeners();
	}

	private void initUI() {
		this.setSize(400, 400);
		this.setTitle("game 1");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		gameRunner = new GameRunner(gameBoard);
		startGame();
		
	}

	private void placeComponents() {
		this.getContentPane().add(gameBoard);
		
	}

	private void bindListeners() {
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				gameBoard.createBall(arg0.getX(), arg0.getY());
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	void startGame(){
		Thread th = new Thread(gameRunner);
		th.start();
	}

}
