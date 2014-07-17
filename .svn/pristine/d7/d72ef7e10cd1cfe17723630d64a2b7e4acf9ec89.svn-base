package com.ita.softserveinc.achiever.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ita.softserveinc.achiever.entity.QuizResult;
import com.ita.softserveinc.achiever.service.IQuizResultService;
/**
 * @author Ruslan Didyk
 */
@Controller
@RequestMapping("/testing")
public class TestingController {
	
	@Autowired
	private IQuizResultService quizService;

	@RequestMapping(value = "/takeTheTest")
	public ModelAndView takeTheTest() {
		return new ModelAndView("takeTheTest");
	}

	@RequestMapping(value = "/my-tests")
	public String showUserTesting(Model model, Principal principal) { 
		String login = principal.getName();
		model.addAttribute("quizResult" , quizService.findAllByUser(login));
		return "testing/my-tests";
	}
	
	@RequestMapping(value="/my-tests/{id}")
	public String showTestDetail(Model model, @PathVariable long id){
		QuizResult quiz = quizService.findById(id);
		model.addAttribute("quizResult", quizService.findOne(quiz));
		return "testing/my-test-detail";
	}
}
