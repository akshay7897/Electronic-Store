package com.ap.exception;

public class CategoryNotFounException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public CategoryNotFounException() {
		// 
	}
	
	public CategoryNotFounException(String message) {
		super(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
