package com.ita.softserveinc.achiever.tool;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ita.softserveinc.achiever.entity.User;

/**
 * 
 * @author Eugene Kopaev
 *
 */
@Component("userPasswordValidator")
public class UserPasswordValidator implements Validator{

	@Override
	public boolean supports(Class<?> supportClass) {
		return User.class.isAssignableFrom(supportClass);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "label.valid.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "label.valid.retypePassword");
		User user = (User) object;
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("password", "label.valid.retypePasswordDifferent");
		}
	}

}
