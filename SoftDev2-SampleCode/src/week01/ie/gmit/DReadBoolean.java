package week01.ie.gmit;

import javax.swing.JOptionPane;

public class DReadBoolean {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("enter true or false",null);
		
		boolean printYes = Boolean.parseBoolean(input);
		
		System.out.println("boolean value is "+printYes);
		if (printYes){
			System.out.println("yes");
		}else{
			System.out.println("no is was not true");	
		}
		

	}

}
