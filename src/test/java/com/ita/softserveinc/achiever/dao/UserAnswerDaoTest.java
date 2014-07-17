package com.ita.softserveinc.achiever.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.ita.softserveinc.achiever.entity.Question;
import com.ita.softserveinc.achiever.entity.QuizResult;
import com.ita.softserveinc.achiever.entity.UserAnswer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionDbUnitTestExecutionListener.class })
@DatabaseSetup("file:src/test/resources/com/ita/softserveinc/achiever/entity/useranswer/before-data.xml")
public class UserAnswerDaoTest {
	
	@Autowired
	private IUserAnswerDao userAnswerDao;
	@Autowired
	private IQuestionDao questionDao;
	@Autowired
	private IQuizResultDao quizResultDao;

	@Test
	@ExpectedDatabase(value = "file:src/test/resources/com/ita/softserveinc/achiever/entity/useranswer/data-create.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testCreate() {
		UserAnswer userAnswer = new UserAnswer();
		userAnswer.setAnswerGrade(25);
		userAnswer.setQuestion(questionDao.findById(Question.class, 3L));
		userAnswer.setQuizResult(quizResultDao.findById(QuizResult.class, 1L));
		userAnswer.setUserAnswer("answer3");
		userAnswerDao.create(userAnswer);
	}

	@Test
	@ExpectedDatabase(value = "file:src/test/resources/com/ita/softserveinc/achiever/entity/quizresult/data-update.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testUpdate() {
		UserAnswer userAnswer = userAnswerDao.findById(UserAnswer.class, 2L);
		userAnswer.setAnswerGrade(40);
		userAnswer.setUserAnswer("answer3");
		userAnswerDao.update(userAnswer);
	}

	@Test
	@ExpectedDatabase(value ="file:src/test/resources/com/ita/softserveinc/achiever/entity/useranswer/data-delete.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void testDelete() {
		UserAnswer userAnswer = userAnswerDao.findById(UserAnswer.class, 2L);
		userAnswerDao.delete(userAnswer);
	}

	@Test
	public void testFindById() {
		UserAnswer userAnswer = userAnswerDao.findById(UserAnswer.class, 1L);
		assertEquals("answer1", userAnswer.getUserAnswer());
	}

	@Test
	public void testFindAll() {
		List<UserAnswer> userAnswers = userAnswerDao.findAll(UserAnswer.class);
		assertEquals(2, userAnswers.size());
	}

}
