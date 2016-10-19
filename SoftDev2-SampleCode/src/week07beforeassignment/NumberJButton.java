package week07beforeassignment;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class NumberJButton extends JButton{
	public NumberJButton(String text){
		super(text);
		this.setFont(new Font("Ariel",Font.BOLD,16));
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setBackground(Color.lightGray);
		
		bindListerers();
	}

	private void bindListerers() {
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent arg0) {
				onMouseEnter(arg0);	
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				onMouseExit(arg0);
				
			}
		});
		
	}

	public void onMouseEnter(MouseEvent me){
		this.setBackground(Color.GRAY);
	}
	public void onMouseExit(MouseEvent me){
		this.setBackground(Color.LIGHT_GRAY);
		
	}

}
