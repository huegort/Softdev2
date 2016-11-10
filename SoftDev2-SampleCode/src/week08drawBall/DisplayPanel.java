package week08drawBall;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class DisplayPanel extends JPanel {
	Ball2 currentBall = null;
	List<Ball2> balls = new ArrayList<Ball2>();
	Color currentColor = Color.BLACK;

	public DisplayPanel(){
		bindListeners();
	}
	public void paint(Graphics g){
		g.clearRect(0, 0, this.getWidth(), this.getHeight());

		for (Ball2 ball : balls){
			ball.draw(g);
		}
		if (currentBall != null){
			currentBall.draw(g);
			g.drawString(currentBall.getDetails(), 10, 10);
		}

	}


	private void bindListeners() {
		this.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent arg0) {
				onDrag(arg0);
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

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
				onMouseDown(arg0);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				onMouseUp();
			}

		});
			}

	public void onMouseDown(MouseEvent me){
		currentBall = new Ball2(currentColor);
		currentBall.setCenter(me.getX(), me.getY());
	}
	public void onMouseUp(){
		balls.add(currentBall);
		currentBall = null;
		repaint();
	}
	public void onDrag(MouseEvent me){
		currentBall.radiusTo(me.getX(), me.getY());
		repaint();
	}
	public void onKey(KeyEvent ke){
		System.out.print("on Key ");
		char key = ke.getKeyChar();
		switch (key){
			case('w'):currentColor = Color.WHITE; break;
			case('b'):currentColor = Color.BLACK; break;
			case('r'):currentColor = Color.RED; break;
			case('g'):currentColor = Color.GREEN; break;
			case('l'):currentColor = Color.BLUE; break;
			case('m'):currentColor = Color.MAGENTA; break;
			case('y'):currentColor = Color.YELLOW; break;
		}
		System.out.print("current color "+this.currentColor);
		
		if (currentBall !=  null){
			currentBall.c = currentColor;
		}
		repaint();

	}

}
