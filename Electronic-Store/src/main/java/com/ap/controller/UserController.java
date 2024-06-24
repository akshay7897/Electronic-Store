package com.ap.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ap.dtos.UserRequest;
import com.ap.dtos.UserResponse;
import com.ap.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// create
	@PostMapping(value = "/create")
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request){
		
		UserResponse createdUser = userService.createUser(request);
		return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
	}
	
	//update
	@PutMapping(value = "/update/{userId}")
	public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest request,@PathVariable(name="userId") String userId){
		
		UserResponse updatedUser = userService.updateUser(request, userId);
		return new ResponseEntity<>(updatedUser,HttpStatus.CREATED);
	}
	
	//Delete
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable(name = "userId") String userId){
		
		Boolean deleteUser = userService.deleteUser(userId);
		if(deleteUser) {
			return new ResponseEntity<>("User Deleted", HttpStatus.OK);
		}
		return null;
	}
	
	@GetMapping("/getuser/{userId}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable(name = "userId") String userId){
		
		UserResponse userResponse = userService.getUserByID(userId);
		return new ResponseEntity<>(userResponse,HttpStatus.OK);
	}
	
	@GetMapping("/getusers")
	public ResponseEntity<List<UserResponse>> getUsers(){
		
		List<UserResponse> allUsers = userService.getAllUsers();
		return new ResponseEntity<>(allUsers,HttpStatus.OK);
	}
	
	@GetMapping("/getbyname")
	public ResponseEntity<List<UserResponse>> getByName(@RequestParam(name ="keywords") String keywords){
		
		List<UserResponse> searchUsers = userService.searchUsers(keywords);
	
		return new ResponseEntity<>(searchUsers,HttpStatus.OK);
	}

	@GetMapping("/getuserbyemail/{email}")
	public ResponseEntity<UserResponse> getUserByEmail(@PathVariable(name = "email") String email){
		
		UserResponse userByEmail = userService.getUserByEmail(email);
		
		return new ResponseEntity<>(userByEmail,HttpStatus.OK);
	}
	
	
	

}
