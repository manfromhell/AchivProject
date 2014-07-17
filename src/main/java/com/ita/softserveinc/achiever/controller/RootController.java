package com.ita.softserveinc.achiever.controller;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ita.softserveinc.achiever.entity.Role;
import com.ita.softserveinc.achiever.entity.User;
import com.ita.softserveinc.achiever.service.IRoleService;
import com.ita.softserveinc.achiever.service.IUserService;

/**
 * 
 * @author Ruslan Yanyuk
 */
@Controller
public class RootController {

	private static final Logger logger = LoggerFactory
			.getLogger(AboutController.class);
	private static final String MANAGER = "ROLE_MANAGER";

	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;

	@RequestMapping(value = "/root/createmanager", method = RequestMethod.GET)
	public String createManagerPage(Model model) {
		logger.info("Createmanager page !");

		model.addAttribute("user", new User());
		return "createmanager";
	}

	@RequestMapping(value = "/root/addManager", method = RequestMethod.POST)
	public String addManager(@ModelAttribute("user") User user,
			BindingResult result) {
		Role managerRole;

		try {
			managerRole = roleService.findByType(MANAGER);
			if (managerRole == null) {
				managerRole = new Role(MANAGER);
				roleService.create(managerRole);
				user.setRole(managerRole);
				userService.create(user);
			} else {
				userService.create(user);
				user.setRole(managerRole);
				userService.update(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Failed to add manager!");
		}

		return "redirect:/listofmanagers";
	}

	@RequestMapping(value = "/listofmanagers", method = RequestMethod.GET)
	public ModelAndView adminHome() {
		logger.info("List of managers!");
		ModelAndView mav = new ModelAndView();
		
		try {
		Role managerRole = roleService.findByType(MANAGER);
		mav.addObject("userList", userService.getAllByRole(managerRole));
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("userList", Collections.emptyList());
		}
		mav.setViewName("listofmanagers");
		mav.addObject("user", new User());

		return mav;
	}
	
	@RequestMapping(value = "/root/listofmanagers", method = RequestMethod.GET)
	public String redirectToListOfManagers() {
		return "redirect:/listofmanagers";
	}
}
