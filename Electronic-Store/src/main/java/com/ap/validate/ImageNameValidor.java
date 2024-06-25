package com.ap.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ImageNameValidor implements ConstraintValidator<ImageNameValid,String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(value.isBlank()) {
			return false;
		}else {
			return true;
		}
	}


}
