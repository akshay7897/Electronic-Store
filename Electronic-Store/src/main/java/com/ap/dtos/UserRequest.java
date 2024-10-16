package com.ap.dtos;

import com.ap.validate.ImageNameValid;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserRequest {
	
	private String userId;
	@NotBlank(message = "Name Should not be null")
	private String name;
	
	@NotBlank(message = "Email should be unique or not null")
	@Pattern(regexp = "^[a-zA-Z0-9_.±]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$" ,message = "Invalid Email")
	private String email;
	
	@NotBlank(message = "Password should not be null")
	private String password;
	
	@NotBlank(message = "Gender should not null")
	private String gender;
	
	@NotBlank(message = "About should not null")
	private String about;
	
	@ImageNameValid(message = "Image name should not be null")
	private String userImage;
	
	public UserRequest() {
		// 
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	@Override
	public String toString() {
		return "UserRequest [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", about=" + about + ", userImage=" + userImage + "]";
	}
	
	
	
	

}
