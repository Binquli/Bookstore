package hh.swd20.BookStore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private int year;
	private int isbn;
	private String price;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;

	public Book() {
		super();	
		this.id = null;
		this.title = null;
		this.author = null;
		this.price = null;
		this.isbn = 0;
		this.year = 0;
	}
	public Book(String title, String author, String price, int year, int isbn, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.year = year;
		this.isbn = isbn;
		this.category = category;
	}
	public Book(Long id, String title, String author, String price, int year, int isbn, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.year = year;
		this.isbn = isbn;
		this.category = category;
	}
	public Long getId() {
		return id;
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
	public void setId(Long id) {
		this.id = id;
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
	public void setCategory(Category category) {
		this.category = category;
	}
	public Category getCategory() {
		return category;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn
				+ ", price=" + price + "]";
	}

	

}
