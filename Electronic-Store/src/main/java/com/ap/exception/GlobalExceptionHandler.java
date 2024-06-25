package com.ap.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ap.dtos.ApiResponseMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = UserNotFoudException.class)
	public ResponseEntity<ApiResponseMessage> userNotFoundExceptionHandler(UserNotFoudException exception){
		
		ApiResponseMessage message=new ApiResponseMessage();
		message.setMessage(exception.getMessage());
		message.setSuccess(false);
		message.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception){
		
		 List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
		 Map<String, Object> message=new HashMap<>();
		 allErrors.stream().forEach(obj->{
			 String errorMessage = obj.getDefaultMessage();
			 String field = ((FieldError)obj).getField();
			 message.put(field, errorMessage);
			 
		 });
		return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ApiResponseMessage> ExceptionHandler(Exception exception){
		
		ApiResponseMessage message=new ApiResponseMessage();
		message.setMessage(exception.getMessage());
		message.setSuccess(false);
		message.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
