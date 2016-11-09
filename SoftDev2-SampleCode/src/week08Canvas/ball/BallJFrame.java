package week08Canvas.ball;

import javax.swing.JFrame;

import week08Canvas.DisplayBasic;

public class BallJFrame extends JFrame {
	BallDisplay ballDisplay;
	public BallJFrame(){
		super();
		initUI();
		placeComponents();
		bindListeners();
	}

	private void initUI() {
		this.setSize(400,400);
		this.setTitle("hellow");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private void placeComponents() {
		ballDisplay = new BallDisplay();
		this.getContentPane().add(ballDisplay);
		
	}

	private void bindListeners() {
		// TODO Auto-generated method stub
		
	}
	public void start(){
		Thread th = new Thread(ballDisplay);
		th.start();;	
	}
}
