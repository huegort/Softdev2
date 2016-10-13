package week01.ie.gmit;

import javax.swing.JOptionPane;

public class MainClassB {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("enter something", "enter Here");
		System.out.println(input);
		int l = input.length();
		System.out.println("hAS LENGHT "+l);

	}

}
