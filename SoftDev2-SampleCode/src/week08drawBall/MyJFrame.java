package week08drawBall;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MyJFrame extends JFrame {
	DisplayPanel display = new DisplayPanel();
	
	public MyJFrame(){
		initUI();
		placeComonents();
		bindListeners();
	}

	private void bindListeners() {
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
					
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				display.onKey(arg0);
			}
			
		});

		
	}

	private void initUI() {
		this.setSize(400, 400);
		this.setTitle("draw balls");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private void placeComonents() {
		this.getContentPane().add(display);
		
	}

}
