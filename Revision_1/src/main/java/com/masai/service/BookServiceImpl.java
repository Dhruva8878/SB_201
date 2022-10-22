package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BookException;
import com.masai.model.Book;
import com.masai.repo.BookDAO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	public BookDAO bookDAO; 
	
	@Override
	public Book getBookById(Integer bookId) throws BookException {
		
		Optional<Book> book=bookDAO.findById(bookId);
		
		if(book.isPresent()) {
			return book.get();
		}
		else {
			throw new BookException("No book found by this id :"+bookId);
		}
	}

	@Override
	public Book registerBook(Book book) throws BookException {
		
		Book bk=bookDAO.save(book);
		if(bk!=null) {
			return bk;
		}
		else {
			throw new BookException("Error in registering Book");
		}
	}

	@Override
	public Book updateBook(Book book) throws BookException {
		
		Optional<Book> bk=bookDAO.findById(book.getBookId());
		
		if(bk.isPresent()) {
			return bookDAO.save(book);
		}
		else {
			throw new BookException("please provide right credentials");
		}
		
	}

	@Override
	public Book deleteBook(Integer id) throws BookException {
		
     Optional<Book> book=bookDAO.findById(id);
     
     if(book.isPresent()) {
    	 bookDAO.delete(book.get());
    	 return book.get();
     }
     else {
    	 throw new BookException("No book found by id");
     }
		
		
	}

	@Override
	public List<Book> getAllBooks() throws BookException {
		
		List<Book> books=bookDAO.findAll();
		
		if(books.size()>0) {
			return books;
		}
		else {
			throw new BookException("No books found");
		}
	
	}
	
	


}
