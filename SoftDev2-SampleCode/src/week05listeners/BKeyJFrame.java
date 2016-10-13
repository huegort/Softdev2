package week05listeners;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class BKeyJFrame extends JFrame {
	// Components here
		JLabel displayLabel;
		
		
		public BKeyJFrame(){
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
			displayLabel = new JLabel("Key hit");
			mainPane.add(displayLabel);
			
		}

		private void bindListeners() {
			this.addKeyListener(new KeyListener(){
				@Override
				public void keyPressed(KeyEvent e) {
				}
				@Override
				public void keyReleased(KeyEvent e) {
				}
				@Override
				public void keyTyped(KeyEvent e) {
					onKeyTyped(e);
				}
			});
		}
		private void onKeyTyped(KeyEvent e){
			displayLabel.setText("key typed: "+e.getKeyChar());
		}
}
