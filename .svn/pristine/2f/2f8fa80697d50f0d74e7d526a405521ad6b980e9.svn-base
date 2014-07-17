package com.ita.softserveinc.achiever.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ita.softserveinc.achiever.dao.ISubtopicDao;
import com.ita.softserveinc.achiever.entity.Subtopic;
import com.ita.softserveinc.achiever.entity.Topic;

@Service
public class SubtopicServiceImpl implements ISubtopicService{

	@Autowired
	private ISubtopicDao subtopicDao;
	
	@Transactional (propagation = Propagation.REQUIRED)
	public void create(Subtopic entity) {
		subtopicDao.create(entity);
	}

	@Transactional (propagation = Propagation.REQUIRED)
	public Subtopic update(Subtopic entity) {
		return subtopicDao.update(entity);
	}

	@Transactional (propagation = Propagation.REQUIRED)
	public void delete(Subtopic entity) {
		subtopicDao.delete(entity);
	}

	@Transactional (propagation = Propagation.REQUIRED)
	public Subtopic findById(Long id) {
		return subtopicDao.findById(Subtopic.class, id);
	}

	@Transactional (propagation = Propagation.REQUIRED)
	public List<Subtopic> findAll() {
		return subtopicDao.findAll(Subtopic.class);
	}

	@Transactional (propagation = Propagation.REQUIRED)
	@Override
	public Subtopic findByName(String string) {
		return subtopicDao.findByName(string);
	}

}
