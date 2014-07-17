package com.ita.softserveinc.achiever.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ita.softserveinc.achiever.dao.IQuestionDao;
import com.ita.softserveinc.achiever.entity.Question;
import com.ita.softserveinc.achiever.exception.ElementExistsException;

/**
 * @author Taras Hrytsko
 *
 */
@Service
@Transactional
public class QuestionServiceImpl implements IQuestionService {

	@Autowired
	private IQuestionDao questionDao;

	public void create(Question entity) throws ElementExistsException {
		if (findAll().contains(entity)){
			throw new ElementExistsException();
		}
		questionDao.create(entity);
	}

	public Question update(Question entity) throws ElementExistsException {
		if (findAll().contains(entity)){
			throw new ElementExistsException();
		}
		return questionDao.update(entity);
	}

	public void delete(Question entity) {
		questionDao.delete(entity);
	}

	public Question findById(Long id) {
		return questionDao.findById(Question.class, id);
	}

	public List<Question> findAll() {
		return questionDao.findAll(Question.class);
	}

}
