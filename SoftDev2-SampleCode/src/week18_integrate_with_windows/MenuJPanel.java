package week18_integrate_with_windows;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuJPanel extends JPanel {
	CarJFrame parent;
	public MenuJPanel(CarJFrame parent){
		this.parent = parent;
		
		placeComponents();
		
	}
	private void placeComponents() {
		JLabel message = new JLabel("hi mom");
		this.add(message);
		
	}
}
