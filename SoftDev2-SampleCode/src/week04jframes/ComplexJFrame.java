package week04jframes;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComplexJFrame extends JFrame {
	
	public ComplexJFrame(){
		super();
		initUI();
		placeComponents();
		bindListeners();
	}

	private void initUI() {
		this.setTitle("yo");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private void placeComponents() {
		Container mainPane = this.getContentPane();
		mainPane.setLayout(new BorderLayout());
		
		
		mainPane.add(new JButton("go"), BorderLayout.CENTER);
		
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		mainPane.add(northPanel, BorderLayout.NORTH);
		
		northPanel.add(new JButton("b1"));
		northPanel.add(new JButton("b2"));
		northPanel.add(new JButton("b3"));
		
		
		
	}

	private void bindListeners() {
		// TODO Auto-generated method stub
		
	}

}
