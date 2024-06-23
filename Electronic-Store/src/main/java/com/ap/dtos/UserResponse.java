package com.ap.dtos;

public class UserResponse {
	
	private String userId;
	private String name;
	private String email;
	private String password;
	private String gender;
	private String about;
	private String userImage;
	
	public UserResponse() {
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
		return "UserResponse [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", about=" + about + ", userImage=" + userImage + "]";
	}
	
	

}
