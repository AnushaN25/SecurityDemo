package com.library.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.library.exception.BookAlreadyExistsException;
import com.library.exception.NoBookFoundException;
import com.library.model.Book;
import com.library.serviceImpl.BookServiceImpl;

@RestController
@RequestMapping("/api")
public class BookController 
{
	@Autowired
	 private BookServiceImpl  bookServiceImpl;
	
	@PostMapping(path="/addBook")
	//@RequestMapping(value = "/addBook", method = {RequestMethod.PUT})
	public Book addBook(@RequestBody Book book) throws BookAlreadyExistsException
	{
		return bookServiceImpl.addBook(book);
	}

	@GetMapping(path = "/viewAllBook")
	//@RequestMapping(value = "/viewAllBook",method = {RequestMethod.GET})
	public List<Book> viewAllBook()
	{
		return bookServiceImpl.viewAllBook();
	}
	
	@DeleteMapping(path="/removeBook/{BookId}")
    public void removeBook(@PathVariable int BookId) throws NoBookFoundException
    {
		bookServiceImpl.removeBook(BookId);
        
    }
	@GetMapping(path="/viewBookByAuthor/{author}")
	//@RequestMapping(value = "/viewAllBookByAuthor",method = {RequestMethod.GET})
	public List<Book> viewBookByAuthor(@PathVariable String author)
	{
		return bookServiceImpl.viewBookByAuthor(author);
		
	}
	@PutMapping(path="/updateBook")
      public Book updateBook(@RequestBody Book book) throws NoBookFoundException
	{
		return bookServiceImpl.updateBook(book);
		
		
	}
	@GetMapping(path="/getbookId/{bookId}")
	//@RequestMapping(value = "/getbookId/{bookId}",method = {RequestMethod.GET})
    public Book getBookById(@PathVariable int bookId)
    {
        return bookServiceImpl.getBookById(bookId);
        
    }
}
