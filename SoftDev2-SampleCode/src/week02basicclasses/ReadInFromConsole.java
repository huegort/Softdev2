package week02basicclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadInFromConsole {

	public static void main(String []args) throws IOException{
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("enter title ---->");
		input = br.readLine();
		System.out.println("the title is"+input);
	}
}


