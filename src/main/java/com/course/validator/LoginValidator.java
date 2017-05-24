package com.course.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> paramClass) {
		return false;
	}

	@Override
	public void validate(Object arg0, Errors error) {		
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"email","required.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"password","required.password");
		
	}

}
