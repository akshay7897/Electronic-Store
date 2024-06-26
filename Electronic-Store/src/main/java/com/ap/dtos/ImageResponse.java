package com.ap.dtos;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class ImageResponse {
	
	private String imageName;
	private String message;
	private boolean success;
	private HttpStatus status;
	
	public ImageResponse() {
		//

	}
	public ImageResponse(String imageName, String message, boolean success, HttpStatus status) {
		super();
		this.imageName = imageName;
		this.message = message;
		this.success = success;
		this.status = status;
	}

	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
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
		return "ImageResponse [imageName=" + imageName + ", message=" + message + ", success=" + success + ", status="
				+ status + "]";
	}
	
	
	

}
