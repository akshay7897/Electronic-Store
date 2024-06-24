package com.ap.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ap.dtos.UserRequest;
import com.ap.dtos.UserResponse;
import com.ap.entity.User;
import com.ap.repository.UserRepositry;
import com.ap.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepositry userRepositry;
	
	public UserServiceImpl(UserRepositry userRepositry) {
		super();
		this.userRepositry = userRepositry;
	}

	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	
	@Override
	public UserResponse createUser(UserRequest userRequest) {
		log.info("inside createUser for id : "+userRequest.getUserId());
		
		String userId = UUID.randomUUID().toString();
		userRequest.setUserId(userId);
		User savedUser =null;
		try {
			savedUser= userRepositry.save(getUserEntity(userRequest));
		}catch (Exception e) {
			throw new RuntimeException("Exception Occured while saving user");
		}
		return getResponse(savedUser);
	}

	@Override
	public UserResponse updateUser(UserRequest userRequest, String userId) {
		User updatedUser =null;
		User user = userRepositry.findById(userId).orElseThrow(()->new RuntimeException("User not found with given id ."));
		
		if(null!=userRequest.getName() && " ".equals(userRequest.getName()))
			user.setName(userRequest.getName());
		if(null!=userRequest.getGender() && " ".equals(userRequest.getGender()))
			user.setGender(userRequest.getGender());
		if(null!=userRequest.getAbout() && " ".equals(userRequest.getAbout()))
			user.setAbout(userRequest.getAbout());
		if(null!=userRequest.getEmail() && " ".equals(userRequest.getEmail()))
			user.setEmail(userRequest.getEmail());
		if(null!=userRequest.getPassword() && " ".equals(userRequest.getPassword()))
			user.setPassword(userRequest.getPassword());
		if(null!=userRequest.getUserImage() && " ".equals(userRequest.getUserImage()))
			user.setUserImage(userRequest.getUserImage());
	try {
		 updatedUser = userRepositry.save(user);
	}catch (Exception e) {
		throw new RuntimeException("Exception occured while updating record .");
	}
		return getResponse(updatedUser);
	}

	
	
	@Override
	public Boolean deleteUser(String userId) {
		User user = userRepositry.findById(userId).orElseThrow(()->new RuntimeException("User not found with given id ."));
		userRepositry.delete(user);
		return Boolean.TRUE;
	}

	@Override
	public List<UserResponse> getAllUsers() {
		List<UserResponse> userResponseList=new ArrayList<UserResponse>();
		List<User> usersList = userRepositry.findAll();
		
		for(User user:usersList) {
			userResponseList.add(getResponse(user));
		}
		return userResponseList;
	}

	@Override
	public UserResponse getUserByID(String userId) {
		User user = userRepositry.findById(userId).orElseThrow(()->new RuntimeException("User not found with given id ."));
		return getResponse(user);
	}

	@Override
	public UserResponse getUserByEmail(String email) {
		User user = userRepositry.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found with email id .."));
		return getResponse(user);
	}

	@Override
	public List<UserResponse> searchUsers(String keywords) {
		List<User> users = userRepositry.findByNameContaining(keywords);
		return  users.stream().map(user->getResponse(user)).toList();
	}
	
	
	private UserResponse getResponse(User user) {
		UserResponse userResponse=new UserResponse();
		BeanUtils.copyProperties(user, userResponse);
		return userResponse;
	}
	
	private User getUserEntity(UserRequest request) {
		User user=new User();
		BeanUtils.copyProperties(request, user);
		return user;
	}

}
