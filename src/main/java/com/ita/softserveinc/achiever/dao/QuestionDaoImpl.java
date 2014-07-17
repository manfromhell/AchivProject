package com.ita.softserveinc.achiever.dao;

import org.springframework.stereotype.Repository;

import com.ita.softserveinc.achiever.entity.Question;
import com.ita.softserveinc.achiever.entity.Subtopic;



/**
 * 
 * @author Taras Hrytsko
 *
 */
@Repository
public class QuestionDaoImpl extends GenericDaoImpl<Question> implements IQuestionDao{
	
	public QuestionDaoImpl(){
		
	}

	
	public Question findByName(String name) {
		Question foundresult = null;
		foundresult = entityManager
				.createNamedQuery("Question.findByName", Question.class)
				.setParameter("name", name).getSingleResult();
		return foundresult;
	}

}
