package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.BookException;
import com.masai.model.Book;
import com.masai.repository.BookDAO;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	public BookDAO bkd;
	
	@Override
	public Book saveBook(Book book) {
		
		Book bk=bkd.save(book);
		
		return bk;
		
	}

	@Override
	public Book getBookById(Integer id) throws BookException {
		
		 Optional<Book> bk=bkd.findById(id);
		 
		 if(bk.isPresent()) {
			 return bk.get();
		 }
		 else {
			 throw new BookException("Book Not Found By this Id :"+id);
		 }
		
	}

	@Override
	public List<Book> getAllBook() throws BookException {
		
		List<Book> books=bkd.findAll();
		
		if(books.size()>0) {
			return books;
		}
		else {
			throw new BookException("Not Books found");
		}
	}

	@Override
	public Book deleteBookById(Integer id) throws BookException {
		
		Optional<Book> book=bkd.findById(id);
		
		if(book.isPresent()) {
			Book bk=book.get();
			
			bkd.delete(bk);
			
			return bk;
		}
		else {
			throw new BookException("Book Not found By this Id :"+id);
		}
		
	}

	@Override
	public Book updateBookById(Book book) throws BookException {
		
		Optional<Book> bk=bkd.findById(book.getBookId());
		
		if(bk.isPresent()) {
			return bkd.save(book);
		}
		else {
			throw new BookException("Inavalid Book Details ");	
		}
		
	}

	

}
