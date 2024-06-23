package com.ap.service;

import java.util.List;

import com.ap.dtos.UserRequest;
import com.ap.dtos.UserResponse;

public interface UserService {
	
	//create user
	UserResponse createUser(UserRequest userRequest);
	
	//update user
	UserResponse updateUser(UserRequest userRequest,String userId);
	
	// delete user
	Boolean deleteUser(String userId);
	
	// get all users
	List<UserResponse> getAllUsers();
	
	//get single user by id
	UserResponse getUserByID(String userId);
	
	//get user by email
	UserResponse getUserByEmail(String Email);
	
	// search user
	List<UserResponse> searchUsers(String keywords);

}
