package util;

import logic.User;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		
		User user = (User) command;
		if(!StringUtils.hasLength(user.getUserId())){
			errors.rejectValue("userID", "error.required");
		}
		if(!StringUtils.hasLength(user.getPassword())){
			errors.rejectValue("password", "error.required");
		}
		if(errors.hasErrors()){
			errors.reject("error.input.user");
		}
	}

}
