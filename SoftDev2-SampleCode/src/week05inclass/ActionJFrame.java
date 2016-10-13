package week05inclass;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionJFrame extends JFrame{
	JButton button1 = new JButton("ckick me"); 
	int countClick=0;
	
	public ActionJFrame(){
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
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.getContentPane().add(mainPanel);
		
		mainPanel.add(button1, BorderLayout.CENTER);
		
		
	}

	private void bindListeners() {
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onButton1Clicked(arg0);
			}
		});
	}
	private void onButton1Clicked(ActionEvent ae){
		countClick++;
		button1.setText("i've been clicked "+countClick);
		if (countClick > 1){
			this.setVisible(false);
			JFrame win2 = new MouseMotionJFrame();
			win2.setVisible(true);
			
		}
		
	}
	

}
