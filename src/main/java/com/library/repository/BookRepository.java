package com.library.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.exception.NoBookFoundException;
import com.library.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>
{
   @Query(value="select * from book_details",nativeQuery=true)
   public List<Book> viewAllBook();

   @Query(value="select b from Book b where b.author=:y")
   public List<Book> viewBookByAuthor(@Param("y")String author);
   
   @Query(value="update Book book set book=?1 where book.Book_id=?2")
   public Book updateBook(Book book)throws NoBookFoundException;

   @Query(value="select * from book_details where Book_id=?1",nativeQuery=true)
   public Optional<Book> getBookById(int bookId);

   
  
   
   //@Query(value="select v from VegetablesItems v where v.category=:y")
	//public List<VegetablesItems> viewvegetableList(@Param("y")String category);
   
   
}
