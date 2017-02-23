package week18_integrate_with_windows;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CarJFrame extends JFrame {
	
	JPanel currentJPanel, createJPanel, menuJPanel;
	
	public CarJFrame(){
		initUI();
		placeComponents();
	}

	private void initUI() {
		this.setTitle("car Buyer");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private void placeComponents() {
		createJPanel = new CreateJPanel(this);
		menuJPanel = new MenuJPanel(this);
		currentJPanel = createJPanel;
		
		this.getContentPane().add(currentJPanel);
	}
	public void gotoMenu(){
		//this.removeAll();
		System.out.println("in gotoMenu");
		this.getContentPane().remove(currentJPanel);
		
		currentJPanel = menuJPanel;
		this.getContentPane().add(currentJPanel);
		menuJPanel.repaint(0);
		this.getContentPane().repaint(0);
	
	}
	public void gotoCreate(){
		//this.removeAll();
		currentJPanel = createJPanel;
		this.getContentPane().add(currentJPanel);
		this.repaint();

	}

}
