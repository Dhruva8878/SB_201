package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<Errordetails> employeeExceptionhandler(Errordetails er,WebRequest wq){
		
		Errordetails err=new Errordetails(LocalDateTime.now(),
				er.getMessage(), wq.getDescription(false));
		
		
		return new ResponseEntity<Errordetails>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(AccountException.class)
	public ResponseEntity<Errordetails> accountExceptionhandler(Errordetails er,WebRequest wq){
		
		Errordetails err=new Errordetails(LocalDateTime.now(),
				er.getMessage(), wq.getDescription(false));
		
		
		return new ResponseEntity<Errordetails>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(InsufficientFundException.class)
	public ResponseEntity<Errordetails> InvalidExceptionhandler(Errordetails er,WebRequest wq){
		
		Errordetails err=new Errordetails(LocalDateTime.now(),
				er.getMessage(), wq.getDescription(false));
		
		
		return new ResponseEntity<Errordetails>(err,HttpStatus.NOT_FOUND);
		
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Errordetails> Exceptionhandler(Errordetails er,WebRequest wq){
		
		Errordetails err=new Errordetails(LocalDateTime.now(),
				er.getMessage(), wq.getDescription(false));
		
		
		return new ResponseEntity<Errordetails>(err,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
