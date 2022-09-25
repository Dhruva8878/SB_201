package com.masai.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.masai.Exception.BookException;
import com.masai.model.Book;

public interface BookService {
	
	public Book saveBook(Book book);
	
	public Book getBookById(Integer id)throws BookException;

	public List<Book> getAllBook()throws BookException;
	
	public Book deleteBookById(Integer id)throws BookException;
	
	public Book updateBookById(Book book)throws BookException;

}
