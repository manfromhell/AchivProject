package com.ita.softserveinc.achiever.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ita.softserveinc.achiever.dao.IEventDao;
import com.ita.softserveinc.achiever.entity.Event;
import com.ita.softserveinc.achiever.service.IEventService;

@Service
public class EventServiceImpl implements IEventService{

	@Autowired
	private IEventDao EventDao;
	
	@Transactional
	public void create(Event entity) {
		EventDao.create(entity);
	}

	@Transactional
	public Event update(Event entity) {
		return EventDao.update(entity);
	}

	@Transactional
	public void delete(Event entity) {
		EventDao.delete(entity);
	}

	public Event findById(Long id) {
		return EventDao.findById(Event.class, id);
	}

	public List<Event> findAll() {
		return EventDao.findAll(Event.class);
	}

}
