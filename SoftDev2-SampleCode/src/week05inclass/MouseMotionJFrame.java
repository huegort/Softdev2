package week05inclass;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseMotionJFrame extends JFrame {
	JButton button1 = new JButton("do something");
	
	public MouseMotionJFrame(){
		 initUI();
		 placeComponents();
		 bindListeners();
	 }

	
	private void initUI() {
		this.setSize(400, 400);
		this.setTitle("action stuff");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private void placeComponents() {
		JPanel mainPanel = new JPanel(new FlowLayout());
		this.getContentPane().add(mainPanel);
		
		mainPanel.add(button1);
		
		
	}
	private void bindListeners() {
		this.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				onMouseMoved(arg0);
				
			}
			
		});
		
	}
	
	private void onMouseMoved(MouseEvent me){
		button1.setText("x:"+me.getX()+" y:"+me.getY());
	}


}
