package com.ita.softserveinc.achiever.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ita.softserveinc.achiever.dao.ITopicDao;
import com.ita.softserveinc.achiever.entity.Subtopic;
import com.ita.softserveinc.achiever.entity.Topic;

@Service
public class TopicServiceImpl implements ITopicService{

	@Autowired
	private ITopicDao topicDao;
	
	@Transactional (propagation = Propagation.REQUIRED)
	public void create(Topic entity) {
		topicDao.create(entity);
	}

	@Transactional (propagation = Propagation.REQUIRED)
	public Topic update(Topic entity) {
		return topicDao.update(entity);
	}

	@Transactional (propagation = Propagation.REQUIRED)
	public void delete(Topic entity) {
		topicDao.delete(entity);
	}

	public Topic findById(Long id) {
		return topicDao.findById(Topic.class, id);
	}

	public List<Topic> findAll() {
		return topicDao.findAll(Topic.class);
	}
	
	@Transactional (propagation = Propagation.REQUIRED)
	@Override
	public Topic findByName(String string) {
		return topicDao.findByName(string);
	}
}
