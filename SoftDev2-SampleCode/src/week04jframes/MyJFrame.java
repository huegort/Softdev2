package week04jframes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyJFrame extends JFrame{
	
	public MyJFrame(){
		super();
		initUI();
		placeComponents();
		bindListeners();
	}

	private void initUI() {
		//System.out.println("yer we are sane");
		this.setTitle("Soft Dev 2 first jframe");
		this.setSize(300,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private void placeComponents() {
		Container mainPane = this.getContentPane();
		
		mainPane.setLayout(new BorderLayout());
		
		JLabel helloLabel = new JLabel("hi mom");
		mainPane.add(helloLabel, BorderLayout.NORTH);
		
		JLabel label2 = new JLabel("another one");
		mainPane.add(label2, BorderLayout.WEST);
		
		JButton button1 = new JButton("go go go ");
		mainPane.add(button1, BorderLayout.SOUTH);
		JButton button2 = new JButton("la de da ");
		mainPane.add(button2,BorderLayout.CENTER);
		JButton button3 = new JButton("la de da ");
		mainPane.add(button3,BorderLayout.EAST);
	}

	private void bindListeners() {
		// TODO Auto-generated method stub
		
	}

	
	
}
