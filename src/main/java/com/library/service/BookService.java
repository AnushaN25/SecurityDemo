package com.library.service;

import java.util.List;

import com.library.exception.BookAlreadyExistsException;
import com.library.exception.NoBookFoundException;
import com.library.model.Book;

public interface BookService 
{
	public Book addBook(Book book)throws BookAlreadyExistsException;
	public void removeBook(int Book_id)throws NoBookFoundException;
	public Book updateBook(Book book)throws NoBookFoundException;
	public List<Book> viewAllBook();
	public List<Book> viewBookByAuthor(String author);
	public Book getBookById(int bookId);
	
	
}
