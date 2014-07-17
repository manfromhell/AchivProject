package com.ita.softserveinc.achiever.service;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ita.softserveinc.achiever.dao.IGroupDao;
import com.ita.softserveinc.achiever.entity.Direction;
import com.ita.softserveinc.achiever.entity.Group;
import com.ita.softserveinc.achiever.exception.ElementExistsException;
import com.ita.softserveinc.achiever.exception.InvalidDateException;
import com.ita.softserveinc.achiever.tool.DateValidator;

@Service
public class GroupServiceImpl implements IGroupService {

	@Autowired
	private IGroupDao groupDao;

	@Autowired
	private DateValidator dateValidator;

	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Group entity) throws ElementExistsException,
			InvalidDateException {
		String startStr = entity.getStart();
		String endStr = entity.getEnd();
		if (!(isUnique(entity))) {
			throw new ElementExistsException();
		}
		if (!(isValidDates(startStr, endStr))) {
			throw new InvalidDateException();
		} 
			groupDao.create(entity);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Group update(Group entity) throws ElementExistsException, InvalidDateException {
		String startStr = entity.getStart();
		String endStr = entity.getEnd();
		if (!(isUnique(entity))) {
			throw new ElementExistsException();
		}
		if (!(isValidDates(startStr, endStr))) {
			throw new InvalidDateException();
		} 
		return groupDao.update(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Group entity) {
		groupDao.delete(entity);
	}

	public Group findById(Long id) {
		return groupDao.findById(Group.class, id);
	}

	public List<Group> findAll() {
		return groupDao.findAll(Group.class);
	}

	@Override
	public List<Group> findByName(String name) {
		return groupDao.findByName(name);
	}

	@Override
	public boolean isUnique(Group group) {
		return groupDao.isUnique(group);
	}

	@Override
	public List<Group> findByDirection(Direction direction) {
		return groupDao.findByDirection(direction);
	}
	
	private boolean isValidDate(String date){
		boolean isValid = dateValidator.validate(date);
		if (!isValid){
			return false;
		}
		return true;
	}
	
	private Timestamp parseDate(String date){
		if (!isValidDate(date)){
			return null;
		}
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
		long time = parsedDate.getTime();
		return new Timestamp(time);
	}
	
	public boolean isValidDates(String startStr, String endStr){
		Timestamp startTime = parseDate(startStr);
		Timestamp endTime = parseDate(endStr);
		if ((startTime==null) || (endTime==null)){
			return false;
		}
		if ( (endTime.before(startTime)) || (endTime.equals(startTime))){
			return false;
		}
		return true;
	}

}
