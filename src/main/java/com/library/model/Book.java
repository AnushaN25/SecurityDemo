package com.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="book_details")
public class Book 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int Book_id;
	@NotBlank(message="BookName should not be blank")
	private String bookName;
	@NotBlank(message="AuthorName should not be blank")
	private String author;
	private double price;
	public int getBook_id() {
		return Book_id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setBook_id(int book_id) {
		Book_id = book_id;
	}
	
	
    
}
