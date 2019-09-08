package hh.swd20.BookStore.domain;

public class Book {
	
	private String title;
	private String author;
	private int year;
	private int isbn;
	private String price;
	
	public Book() {
		super();
		this.title = null;
		this.author = null;
		this.price = null;
		this.isbn = 0;
		this.year = 0;
	}
	public Book(String title, String author, String price, int year, int isbn) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.year = year;
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getYear() {
		return year;
	}
	public int getIsbn() {
		return isbn;
	}
	public String getPrice() {
		return price;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price
				+ "]";
	}
	
	

}
