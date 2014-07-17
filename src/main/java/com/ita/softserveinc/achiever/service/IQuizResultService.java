package com.ita.softserveinc.achiever.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ita.softserveinc.achiever.entity.QuizResult;
/**
 * @author Ruslan Didyk
 */
@Component
public interface IQuizResultService extends IGenericService<QuizResult>{

	List<QuizResult> findAllByUser(String login);

	QuizResult findOne(QuizResult quizResult);
}
