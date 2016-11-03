package week07canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyCanvas extends JPanel{
	public MyCanvas(){
		super();
		initUI();
		placeStuff();
		bindListeners();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		
	}

	private void placeStuff() {
		// TODO Auto-generated method stub
		
	}

	private void bindListeners() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void paint(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(100, 100, 110,50);
		g.drawString("hi mom", 50, 100);
	}
	

}
