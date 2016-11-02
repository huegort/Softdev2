package week08Canvas;

import javax.swing.JFrame;

public class BasicJFrame extends JFrame {
	
	public BasicJFrame(){
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
		DisplayBasic displayBasic = new DisplayBasic();
		this.getContentPane().add(displayBasic);
		
	}

	private void bindListeners() {
		// TODO Auto-generated method stub
		
	}

}
