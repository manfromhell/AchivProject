package com.ita.softserveinc.achiever.controller;

import java.security.Principal;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ita.softserveinc.achiever.service.IUserService;

/**
 * 
 * @author Bogdan Rudka
 *
 */

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/login")
	public String login() {
		return "user/login";
	}

	@RequestMapping(value = "/login/failed")
	public String loginFailed(Model model) {
		model.addAttribute("error", true);
		return "user/login";
	}

	@RequestMapping(value = "/403")
	public String permissionDenied() {
		return "error/403";
	}
}
