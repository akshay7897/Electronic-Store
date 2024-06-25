package com.ap.dtos;

public class ApiResponseMessage {
	
	private String message;
	private boolean success;
	
	public ApiResponseMessage() {
		// 
	}

	public ApiResponseMessage(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "ApiResponseMessage [message=" + message + ", success=" + success + "]";
	}
	
	

}
