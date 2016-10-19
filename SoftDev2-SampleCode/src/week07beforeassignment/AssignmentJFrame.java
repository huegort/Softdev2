package week07beforeassignment;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AssignmentJFrame extends JFrame {
	
	JButton b1 = new NumberJButton("1");
	JButton b2 = new NumberJButton("2");
	JButton b3 = new NumberJButton("3");
	JButton b4 = new NumberJButton("4");
	JButton b5 = new NumberJButton("5");
	JButton b6 = new NumberJButton("6");
	JButton b7 = new NumberJButton("7");
	JButton b8 = new NumberJButton("8");
	JButton b9 = new NumberJButton("9");
	JButton b0 = new NumberJButton("0");
	JButton bplusminus = new NumberJButton("+-");
	JButton bdot = new JButton(".");
	
	
	public AssignmentJFrame(){
		super();
		initUI();
		placeComponents();
		bindListeners();
		
	}

	private void initUI() {
		this.setSize(400, 300);
		this.setTitle("assignment");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void placeComponents() {
		JPanel buttonPanel = new JPanel(new GridLayout(4,3));
		this.getContentPane().add(buttonPanel);
		
		
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		buttonPanel.add(b3);
		buttonPanel.add(b4);
		buttonPanel.add(b5);
		buttonPanel.add(b6);
		buttonPanel.add(b7);
		buttonPanel.add(b8);
		buttonPanel.add(b9);
		buttonPanel.add(bplusminus);
		buttonPanel.add(b0);
		buttonPanel.add(bdot);
		
		
		
	}

	private void bindListeners() {
		// TODO Auto-generated method stub
		
	}

}
