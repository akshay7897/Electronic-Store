package com.ap.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.ap.dtos.UserRequest;
import com.ap.dtos.UserResponse;
import com.ap.entity.User;
import com.ap.repository.UserRepositry;
import com.ap.service.UserService;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserResponse> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponse getUserByID(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponse getUserByEmail(String Email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserResponse> searchUsers(String keywords) {
		// TODO Auto-generated method stub
		return null;
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
