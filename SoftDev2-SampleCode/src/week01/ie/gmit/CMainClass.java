package week01.ie.gmit;

import javax.swing.JOptionPane;

public class CMainClass {
//
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("enter a numbner",null);
		
		int number=0;
		try{
			number = Integer.parseInt(input);
		}catch (NumberFormatException nfe){
			System.out.println("enter a number next time");
		}
		System.out.println("that number multiplied by 4 is "+(number*4));

	}

}
