package com.ita.softserveinc.achiever.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ita.softserveinc.achiever.entity.User;
import com.ita.softserveinc.achiever.service.IUserService;

@Controller
public class ManagerController {

	@Autowired
	private IUserService userService;

	@RequestMapping("/managers")
	private String listContacts(Map<String, Object> map) {
		map.put("manager", new User());
		map.put("userList", userService.findIfActive(0, 0));
		return "manager";
	}

}
