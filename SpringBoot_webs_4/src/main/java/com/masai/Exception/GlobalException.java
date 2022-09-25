package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<ErrorDetails> productExceptionHandler(ProductException pe, WebRequest re){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now()
				,pe.getMessage(), re.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails>ExceptionHandler(Exception pe, WebRequest re){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now()
				,pe.getMessage(), re.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
