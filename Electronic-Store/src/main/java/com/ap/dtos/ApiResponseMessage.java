package com.ap.dtos;

import org.springframework.http.HttpStatus;

public class ApiResponseMessage {
	
	private String message;
	private boolean success;
	private HttpStatus status;
	
	public ApiResponseMessage() {
		// 
	}

	public ApiResponseMessage(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}
	

	public ApiResponseMessage(String message, boolean success, HttpStatus status) {
		super();
		this.message = message;
		this.success = success;
		this.status = status;
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

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ApiResponseMessage [message=" + message + ", success=" + success + ", status=" + status + "]";
	}
	
	
	


	
	

}
