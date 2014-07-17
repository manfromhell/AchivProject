package com.ita.softserveinc.achiever.dao;

import org.springframework.stereotype.Repository;

import com.ita.softserveinc.achiever.entity.Topic;

@Repository
public class TopicDaoImpl extends GenericDaoImpl<Topic> implements ITopicDao {

	public TopicDaoImpl() {

	}

	public Topic findByName(String name) {
		Topic foundresult = null;
		foundresult = entityManager
				.createNamedQuery("Topic.findByName", Topic.class)
				.setParameter("name", name).getSingleResult();
		return foundresult;
	}
}