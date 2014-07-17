package com.ita.softserveinc.achiever.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ita.softserveinc.achiever.entity.Role;
import com.ita.softserveinc.achiever.entity.User;

@Component
public interface IUserDao extends IGenericDao<User>{
	
	User findByLogin(String login);
	User findByEmail(String email);

	List<User> findIfActive(Class<User> classUser, int b, int studentCount);
	
	public List<User> getAllByRole(Role role);
}
