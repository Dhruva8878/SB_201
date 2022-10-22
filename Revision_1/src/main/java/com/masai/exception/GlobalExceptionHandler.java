package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BookException.class)
	 public ResponseEntity<ErrorDetails> bookExceptionHandler(BookException e,WebRequest wr){
		
		ErrorDetails er=new ErrorDetails(e.getMessage(), wr.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(er,HttpStatus.NOT_FOUND);
		
	 }

	@ExceptionHandler(Exception.class)
	 public ResponseEntity<ErrorDetails> globalExceptionHandler(Exception e,WebRequest wr){
		
		ErrorDetails er=new ErrorDetails(e.getMessage(), wr.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(er,HttpStatus.NOT_FOUND);
		
	 }
}
