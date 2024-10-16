package com.ap.exception;

public class UserNotFoudException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public UserNotFoudException() {
		super("User Not found..");
	}

	public UserNotFoudException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

}
