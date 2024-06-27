package com.ap.exception;

public class ProductNotFountException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ProductNotFountException() {
		//
	}

	public ProductNotFountException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	

}
