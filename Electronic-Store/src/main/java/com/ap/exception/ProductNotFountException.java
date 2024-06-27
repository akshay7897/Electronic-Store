package com.ap.exception;

public class ProductNotFountException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ProductNotFountException() {
		//
	}

	public ProductNotFountException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "ProductNotFountException [message=" + message + "]";
	}
	
	

}
