package com.ita.softserveinc.achiever.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ita.softserveinc.achiever.entity.Direction;
import com.ita.softserveinc.achiever.entity.Group;

@Component
public interface IGroupDao extends IGenericDao<Group>{
	
	List<Group> findByDirection(Direction direction);
	
	List<Group> findByName(String name);
	
	boolean isUnique(Group group);
	


}
