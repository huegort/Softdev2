package week02basicclasses;

public class Book {
	// are you recieving me over
	String title;
	String author;
	int price;
	
	public Book(){
		
	}
	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
	}

}
