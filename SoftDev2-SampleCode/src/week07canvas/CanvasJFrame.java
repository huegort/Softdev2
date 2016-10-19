package week07canvas;

import java.awt.BorderLayout;
import java.awt.Canvas;

import javax.swing.*;

public class CanvasJFrame extends JFrame{
	Canvas canvas = new MyCanvas();
	public CanvasJFrame(){
		super();
		initUI();
		placeComponents();
		bindListeners();
	}

	private void initUI() {
		this.setSize(400, 300);
		this.setTitle("canvas");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void placeComponents() {
		this.getContentPane().add(canvas, BorderLayout.CENTER);
		
	}

	private void bindListeners() {
		// TODO Auto-generated method stub
		
	}

}
