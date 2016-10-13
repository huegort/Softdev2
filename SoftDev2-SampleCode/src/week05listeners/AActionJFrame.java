package week05listeners;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class AActionJFrame extends JFrame {
	// Components here
	JButton clickMeButton;
	
	
	public AActionJFrame(){
		super();
		initUI();
		placeComponents();
		bindListeners();
	}

	private void initUI() {
		this.setSize(400,400);
		this.setTitle("action listners");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private void placeComponents() {
		Container mainPane = this.getContentPane();
		mainPane.setLayout(new FlowLayout());
		clickMeButton = new JButton("Click Me");
		mainPane.add(clickMeButton);
		
	}

	private void bindListeners() {
		clickMeButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				onClickMeButtonClicked(ae);
			}
		});
		

	}
	private void onClickMeButtonClicked(ActionEvent ae){
		clickMeButton.setText("Clicked");
	}
	
	private void onMouseEntersClickMeButton(MouseEvent me){
		clickMeButton.setBackground(Color.RED);
	
	}
	private void onMouseExitsClickMeButton(MouseEvent me){
		clickMeButton.setBackground(Color.GRAY);
	}
	
}
