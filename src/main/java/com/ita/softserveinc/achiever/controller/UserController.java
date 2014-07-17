package com.ita.softserveinc.achiever.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ita.softserveinc.achiever.entity.User;
import com.ita.softserveinc.achiever.exception.UserDataVerificationException;
import com.ita.softserveinc.achiever.exception.UserException;
import com.ita.softserveinc.achiever.exception.UserExistException;
import com.ita.softserveinc.achiever.service.IUserService;

/**
 * 
 * @author Bogdan Rudka
 *
 */
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registrationForm(Model model) {
		model.addAttribute("user", new User());
		return "user/registration-form";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String registration(@Valid User user, BindingResult result,
			Model model) throws UserException {
		logger.info(user.getConfirmPassword() + "  " + user.getPassword());
		if (!result.hasErrors()) {
			// by default user.active = 0, user.studentCount = 0
			logger.info("User registration is start");
			try {
				userService.create(user);
			} catch (UserExistException e) {
				e.printStackTrace();
				logger.info("User with sutch login already exist");
				model.addAttribute("userExistParameter", e.getParameter());
				return "user/registration-form";
			} catch (UserDataVerificationException e) {
				logger.info("User password does not match confirm password");
				model.addAttribute("confirmPasswordFail", true);
				return "user/registration-form";
			}
			logger.info("User registration is successful");
			return "redirect:/home";
		} else {
			logger.info("User registration is unsuccessful");
			return "user/registration-form";
		}
	}
}
