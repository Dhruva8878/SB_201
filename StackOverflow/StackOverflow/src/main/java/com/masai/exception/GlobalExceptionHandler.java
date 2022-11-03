package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(TagException.class)
	public ResponseEntity<ErrorDetails> ExceptionHandler(TagException e, WebRequest req) {
		
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(QuestionException.class)
	public ResponseEntity<ErrorDetails> ExceptionHandler(QuestionException e, WebRequest req) {
		
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> ExceptionHandler(Exception e, WebRequest req) {

		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));

		return new ResponseEntity<ErrorDetails>(err,HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
