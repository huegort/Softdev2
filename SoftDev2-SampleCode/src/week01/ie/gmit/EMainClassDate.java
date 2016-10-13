package week01.ie.gmit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
public class EMainClassDate {
	public static void main(String[] args) {
		String dateString = JOptionPane.showInputDialog("enter a date",null);
		DateTimeFormatter inputFormatter =
				DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dateString, inputFormatter);
		// now output
		DateTimeFormatter outputFormatter =
				DateTimeFormatter.ofPattern("dd MMMM YY");
		String out = date.format(outputFormatter);
		System.out.println("date in new format is "+out);
	}
}