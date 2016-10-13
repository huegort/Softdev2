package week02basicclasses;

public class MainClass {

	public static void main(String[] args) {
		Book book = new Book("in the name of the father","E Jordan",800);
		
		System.out.println("title :"+book.title);
		System.out.println("author :"+book.author);
		System.out.println("price :€"+book.price/100 +"."+book.price%100);

	}

}
