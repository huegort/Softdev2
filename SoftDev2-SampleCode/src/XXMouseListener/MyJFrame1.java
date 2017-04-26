package XXMouseListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyJFrame1 extends JFrame{
	JButton b = new JButton("0");
	int count = 0;
	public MyJFrame1(){
		initUI();
		placeComponents();
		bindListeners();
		
	}

	private void initUI() {
		this.setSize(400,400);
		this.setTitle("mouse");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private void placeComponents() {
		this.getContentPane().add(b);
	}

	private void bindListeners() {
		b.addMouseListener(
				new MouseListener(){
					public void mouseClicked(MouseEvent me){
						
					}
					public void mouseEntered(MouseEvent me){
						onMouseEntered(me);
					}
					public void mouseExited(MouseEvent me){
						
					}
					public void mousePressed(MouseEvent me){
						
					}
					public void mouseReleased(MouseEvent me){
						
					}
					
				}
				);
		
	}
	private void onMouseEntered(MouseEvent me){
		String output = "entered ("+(++count)+")";
		
		b.setText(output);
	}

}
