package com.ita.softserveinc.achiever.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ita.softserveinc.achiever.dao.IRoleDao;
import com.ita.softserveinc.achiever.dao.IUserDao;
import com.ita.softserveinc.achiever.entity.Role;
import com.ita.softserveinc.achiever.entity.User;
import com.ita.softserveinc.achiever.exception.UserDataVerificationException;
import com.ita.softserveinc.achiever.exception.UserException;
import com.ita.softserveinc.achiever.exception.UserExistException;

@Service
public class UserServiceImpl implements IUserService {

	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class);
	@Autowired
	private IUserDao userDao;

	@Autowired
	private IRoleDao roleDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public void create(User user) throws UserException {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		logger.info("User login check.");
		if (userDao.findByLogin(user.getLogin()) != null) {
			logger.info("User login:" + user.getLogin() + " is exist:");
			throw new UserExistException("login");
		}
		logger.info("User e-mail check.");
		if (userDao.findByEmail(user.getEmail()) != null) {
			logger.info("User e-mail:" + user.getEmail() + " is exist:");
			throw new UserExistException("email");
		}
		logger.info("User password confirmation check.");
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			logger.info("User password confirmation fail.");
			throw new UserDataVerificationException("passwordConfirm");
		}
			// assign the user role ROLE_USER
			user.setRole(roleDao.findById(Role.class, 4L));

			logger.info("Password encryption");
			// password encryption
			user.setPassword(encoder.encode(user.getPassword()));
			userDao.create(user);
			logger.info("User registration complete");
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public User update(User user) {
		return userDao.update(user);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(User user) {
		userDao.delete(user);
	}

	public User findById(Long id) {
		User user = userDao.findById(User.class, id);
		return user;
	}

	public List<User> findAll() {
		return userDao.findAll(User.class);
	}

	public User findByLogin(String login) {
		return userDao.findByLogin(login);
	}

	public List<User> findIfActive(int active, int studentCount) {
		return userDao.findIfActive(User.class, active, studentCount);
	}

	public List<User> getAllByRole(Role role) {
		return userDao.getAllByRole(role);
	}

}
