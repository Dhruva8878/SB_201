package com.log.exception;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(LoginException.class)
	public ErrorDetails loginExceptionHandler(ErrorDetails er, WebRequest req) {
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now()
				    , er.getMessage(), req.getDescription(false));
		
		
		return err;
		
	}
	
	@ExceptionHandler(SingUpException.class)
	public ErrorDetails SignUpExceptionHandler(ErrorDetails er, WebRequest req) {
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now()
				    , er.getMessage(), req.getDescription(false));
		
		
		return err;
		
	}
	
	@ExceptionHandler(Exception.class)
	public ErrorDetails ExceptionHandler(ErrorDetails er, WebRequest req) {
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now()
				    , er.getMessage(), req.getDescription(false));
		
		
		return err;
		
	}
}
