package com.ap.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ap.dtos.ApiResponseMessage;
import com.ap.dtos.ImageResponse;
import com.ap.dtos.PageableResponse;
import com.ap.dtos.UserRequest;
import com.ap.dtos.UserResponse;
import com.ap.service.FileService;
import com.ap.service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	private FileService fileService;
	
	@Value("${user.profile.image.path}")
	private String imageUploadPath;

	public UserController(UserService userService,FileService fileService) {
		this.userService = userService;
		this.fileService=fileService;
	}
	
	// create
	@PostMapping(value = "/create")
	public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request){
		
		UserResponse createdUser = userService.createUser(request);
		return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
	}
	
	//update
	@PutMapping(value = "/update/{userId}")
	public ResponseEntity<UserResponse> updateUser(@Valid @RequestBody UserRequest request,@PathVariable(name="userId") String userId){
		
		UserResponse updatedUser = userService.updateUser(request, userId);
		return new ResponseEntity<>(updatedUser,HttpStatus.CREATED);
	}
	
	//Delete
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable(name = "userId") String userId){
		
		Boolean deleteUser = userService.deleteUser(userId);
		if(deleteUser) {
			return new ResponseEntity<>(new ApiResponseMessage("User Deleted", Boolean.TRUE), HttpStatus.OK);
		}
		return null;
	}
	
	@GetMapping("/getuser/{userId}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable(name = "userId") String userId){
		
		UserResponse userResponse = userService.getUserByID(userId);
		return new ResponseEntity<>(userResponse,HttpStatus.OK);
	}
	
	@GetMapping("/getusers")
	public ResponseEntity<PageableResponse<UserResponse>> getUsers(
			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
			@RequestParam(value = "sortBy",defaultValue = "name",required = false) String sortBy,
			@RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortdir

			){
		
		PageableResponse<UserResponse> allUsers = userService.getAllUsers(pageNumber,pageSize,sortBy,sortdir);
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
	
	@PostMapping("/image/{userId}")
	public ResponseEntity<ImageResponse> uploadUserImage(@RequestParam("userImage") MultipartFile file,@PathVariable(name = "userId") String userId){
		
		String imageName = fileService.uploadFile(file, imageUploadPath);
		
		UserResponse userResponse = userService.getUserByID(userId);
		userResponse.setUserImage(imageName);
		UserRequest userRequest=new UserRequest();
		BeanUtils.copyProperties(userResponse, userRequest);
		userService.updateUser(userRequest, userId);
		
		ImageResponse response=new ImageResponse();
		response.setImageName(imageName);
		response.setSuccess(true);
		response.setStatus(HttpStatus.CREATED);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/image/{userId}")
	public void serveImage(@PathVariable("userId") String userId,HttpServletResponse response) {
		
		UserResponse userResponse = userService.getUserByID(userId);
		
		InputStream resource = fileService.getResource(imageUploadPath, userResponse.getUserImage());
		
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		try {
			StreamUtils.copy(resource, response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
