package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(BookException.class)
	public ResponseEntity<ErrorDetails> bookExceptionHandler(BookException be, WebRequest re){
		
		
		 ErrorDetails er=new ErrorDetails();
		 er.setLdt(LocalDateTime.now());
		 er.setMessage(be.getMessage());
		 er.setDetails(re.getDescription(false));
		 
		 return new ResponseEntity<ErrorDetails>(er,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> ExceptionHandler(Exception be, WebRequest re){
		
		
		 ErrorDetails er=new ErrorDetails();
		 er.setLdt(LocalDateTime.now());
		 er.setMessage(be.getMessage());
		 er.setDetails(re.getDescription(false));
		 
		 return new ResponseEntity<ErrorDetails>(er,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
