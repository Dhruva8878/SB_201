package com.masai.Exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	
	private LocalDateTime ldt;
	private String message;
	private String details;
	
	public ErrorDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public ErrorDetails(LocalDateTime ldt, String message, String details) {
		super();
		this.ldt = ldt;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getLdt() {
		return ldt;
	}

	public void setLdt(LocalDateTime ldt) {
		this.ldt = ldt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
	

}
