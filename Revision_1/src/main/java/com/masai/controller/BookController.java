package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BookException;
import com.masai.model.Book;
import com.masai.service.BookService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController("/bookservice")
public class BookController {

	@Autowired
	 public BookService bookService;
	
	@PostMapping("/books")
	public ResponseEntity<Book> registerBookHadler(@RequestBody Book book) throws BookException{
		
		Book bk= bookService.registerBook(book);
		
		return new ResponseEntity<Book>(bk,HttpStatus.CREATED);
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBookbyIdHandler(@PathVariable("id") Integer id) throws BookException{
		
		Book book= bookService.getBookById(id);
		
		return new ResponseEntity<Book>(book,HttpStatus.OK);
		
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBookHandler() throws BookException{
		
		List<Book> books=bookService.getAllBooks();
		
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delbook/{id}")
	public ResponseEntity<Book> deleteBookHandler(@PathVariable("id") Integer id) throws BookException{
		
		Book book=bookService.deleteBook(id);
		
		return new ResponseEntity<Book>(book,HttpStatus.OK);
		
	}
	
	@PutMapping("/books")
	public ResponseEntity<Book> updateBookHandler(@RequestBody Book book) throws BookException{
		
		Book bk=bookService.updateBook(book);
		
		return new ResponseEntity<Book>(bk,HttpStatus.OK);
		
	}
	
}

