package com.ita.softserveinc.achiever.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ita.softserveinc.achiever.entity.Question;
import com.ita.softserveinc.achiever.entity.Subtopic;
import com.ita.softserveinc.achiever.exception.ElementExistsException;
import com.ita.softserveinc.achiever.exception.InvalidDateException;
import com.ita.softserveinc.achiever.service.IQuestionService;
import com.ita.softserveinc.achiever.service.ISubtopicService;

/**
 * @author Taras Hrytsko
 *
 */
@Controller
public class QuestionController {

	private static final Logger logger = LoggerFactory
			.getLogger(QuestionController.class);

	@Autowired
	private IQuestionService questionService;

	@Autowired
	private ISubtopicService subtopicService;

	private Question editableQuestion;

	/**
	 * @param map
	 * @return questions
	 */
	@RequestMapping("/questions")
	public String listQuestions(Map<String, Object> map) {
		map.put("question", new Question());
		map.put("questionList", questionService.findAll());
		logger.info(questionService.findAll().toString());
		logger.info("/questions");
		return "question/question";
	}

	/**
	 * @param map
	 * @return newquestion
	 */
	@RequestMapping("/newquestion")
	public String newQuestionForm(Map<String, Object> map) {
		logger.info("/newquestion");
		map.put("question", new Question());
		map.put("subtopicList", subtopicService.findAll());
		return "question/newquestion";
	}

	/**
	 * @param question
	 * @param subtopic
	 * @param result
	 * @return questions
	 */
	@RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	public String addQuestion(@ModelAttribute("question") Question question,
			@ModelAttribute("subtopic") Subtopic subtopic, BindingResult result) {
		logger.info("/newquestion");
		if (result.hasErrors()) {
			return "question/newquestion";
		}
		try {
			question.setSubtopic(subtopicService.findByName(subtopic.getName()));
			questionService.create(question);
		} catch (ElementExistsException e) {
			result.reject("question", "such question exists");
			logger.error("such question exists");
		}
		return "redirect:/questions";
	}

	/**
	 * @param id
	 * @return questions
	 */
	@RequestMapping("/question/delete/{questionId}")
	public String deleteQuestion(@PathVariable("questionId") Long id) {
		Question question = questionService.findById(id);
		logger.info("delete element " + question);
		questionService.delete(question);
		logger.info("delete succesful");
		return "redirect:/questions";
	}

	/**
	 * @param map
	 * @return editquestion
	 */
	@RequestMapping(value = "/question/edit/{questionId}")
	public String editQuestionForm(@PathVariable("questionId") Long id,
			Map<String, Object> map) {
		logger.info("/editquestion");
		editableQuestion = questionService.findById(id);
		map.put("question", questionService.findById(id));
		map.put("subtopicList", subtopicService.findAll());
		return "question/editquestion";
	}

	/**
	 * @param id
	 * @return questions
	 */
	@RequestMapping(value = "/question/edit/editQuestion", method = RequestMethod.POST)
	public String editQuestion(@Valid @ModelAttribute("question") Question question,
			@ModelAttribute("subtopic") Subtopic subtopic, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/editquestion";
		}
		if (question.getName().equals(editableQuestion.getName())
				&& (question.getSubtopic().equals(editableQuestion
						.getSubtopic()))) {
			return "redirect:/questions";
		}
		try {
			editableQuestion.setName(question.getName());
			editableQuestion.setSubtopic(subtopicService.findByName(subtopic
					.getName()));
			questionService.update(editableQuestion);
		} catch (ElementExistsException e) {
			result.rejectValue("name", "error.question",
					"this question already exists!");
			return "redirect:/editquestion";
		}
		return "redirect:/questions";
	}
}
