package com.ita.softserveinc.achiever.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ita.softserveinc.achiever.entity.Subtopic;
import com.ita.softserveinc.achiever.entity.Topic;


@Repository
public class SubtopicDaoImpl extends GenericDaoImpl<Subtopic> implements ISubtopicDao{

	public SubtopicDaoImpl() {
		
	}

	public Subtopic findByName(String string) {
		Subtopic resultSubtopic = null;
		List<Subtopic> allSubtopics = findAll(Subtopic.class);
		for (Subtopic subtopic: allSubtopics) {
			if (subtopic.getName().equals(string)) {
				resultSubtopic = subtopic;
			}
		}
		return resultSubtopic;
	}

}
