package com.library.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.exception.BookAlreadyExistsException;
import com.library.exception.NoBookFoundException;
import com.library.model.Book;
import com.library.repository.BookRepository;
import com.library.service.BookService;

@Service
public class BookServiceImpl implements BookService
{
	Logger logger=org.slf4j.LoggerFactory.getLogger(BookServiceImpl.class);
	@Autowired
	BookRepository bookrepos;

	@Override
	public Book addBook(Book book) throws BookAlreadyExistsException {
		if(bookrepos.existsById(book.getBook_id()))
		{
			
			throw new BookAlreadyExistsException("Book already exists");
		}
		else
		{
			
			return bookrepos.save(book);
		}	
		
	}

	@Override
	public void removeBook(int Book_id) throws NoBookFoundException {
		 Book book = bookrepos.getById(Book_id);
	        if(bookrepos.existsById(Book_id))
	        {
	            bookrepos.delete(book);
	        }
		
	}
	
	
	

	@Override
	public List<Book> viewAllBook() {
		List<Book> list = bookrepos.findAll();
		return list;
	}

	@Override
	public Book updateBook(Book book) throws NoBookFoundException {
		if(bookrepos.existsById(book.getBook_id()))
	    {
			
			return bookrepos.save(book);
		}
		else
		{
			throw new NoBookFoundException("book does not exists");
		}
		
		
	}

	@Override
	public List<Book> viewBookByAuthor(String author) {
		List<Book> list = bookrepos.viewBookByAuthor(author);
		return list;
	}

	@Override
	public Book getBookById(int bookId) {
		if(bookrepos.existsById(bookId))
        {
            Optional<Book> opt = bookrepos.getBookById(bookId);
            Book book =opt.get();
            return book;
        }
		return null;
	}
	}

	
	

	
	

	


