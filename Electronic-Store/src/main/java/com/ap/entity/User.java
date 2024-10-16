package com.ap.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "user_details")
public class User {
	
	@Id
	private String userId;
	
	@NotBlank(message = "Name Should not be null")
	private String name;
	
	@Column(name="user_email", unique =true)
	@NotBlank(message = "Email should be unique or not null")
	private String email;
	
	@NotBlank(message = "Password should not be null")
	private String password;
	
	@NotBlank(message = "Gender should not null")
	private String gender;
	
	@NotBlank(message = "About should not null")
	private String about;
	
	private String userImage;
	
	@OneToMany(mappedBy = "userId",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private List<Order> order=new ArrayList<>();
	

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
	

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", about=" + about + ", userImage=" + userImage + ", order=" + order + "]";
	}

	

	
	
	
	
	//
	
	
	
	
	

}
