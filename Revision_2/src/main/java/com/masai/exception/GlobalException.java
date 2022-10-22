package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(CommentException.class)
	public ResponseEntity<ErrorDetails> commentExceptionHandler(PostException e,WebRequest wr){
		 
		ErrorDetails er=new ErrorDetails(e.getMessage(), wr.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(er,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PostException.class)
	public ResponseEntity<ErrorDetails> postExceptionHandler(PostException e,WebRequest wr){
		 
		ErrorDetails er=new ErrorDetails(e.getMessage(), wr.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(er,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SignUpException.class)
	public ResponseEntity<ErrorDetails> signUpExceptionHandler(SignUpException e,WebRequest wr){
		 
		ErrorDetails er=new ErrorDetails(e.getMessage(), wr.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(er,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorDetails> loginExceptionHandler(LoginException e,WebRequest wr){
		 
		ErrorDetails er=new ErrorDetails(e.getMessage(), wr.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(er,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> globalExceptionHandler(Exception e,WebRequest wr){
		 
		ErrorDetails er=new ErrorDetails(e.getMessage(), wr.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(er,HttpStatus.BAD_REQUEST);
	}

}
