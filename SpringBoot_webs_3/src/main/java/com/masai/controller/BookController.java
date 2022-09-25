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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.BookException;
import com.masai.model.Book;
import com.masai.service.BookService;

@RestController
public class BookController {

	@Autowired
	public BookService srv; 
	
	@PostMapping("/books")
	public ResponseEntity<Book> saveBookHandler(@RequestBody Book book) {
		
	    Book bk=srv.saveBook(book);
	    
	    return new ResponseEntity<Book>(bk,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookByIdHandler(@PathVariable("id") Integer id) throws BookException{
		
		Book bk=srv.getBookById(id);
		 
		 return new ResponseEntity<Book>(bk,HttpStatus.OK);
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooksHandler() throws BookException{
		
		List<Book> books=srv.getAllBook();
		
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Book> deleteBookbyIdhandler(@PathVariable("id") Integer id) throws BookException{
		
		Book bk=srv.deleteBookById(id);
		
		return new ResponseEntity<Book>(bk,HttpStatus.OK);
	}
	
	@PutMapping("/books")
	public ResponseEntity<Book> updateBookHandler(@RequestBody Book book) throws BookException{
		
		Book bk=srv.updateBookById(book);
		
		return new ResponseEntity<Book>(bk,HttpStatus.OK);
	}
	
}
