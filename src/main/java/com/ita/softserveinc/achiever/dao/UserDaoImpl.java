package com.ita.softserveinc.achiever.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import com.ita.softserveinc.achiever.entity.Role;
import com.ita.softserveinc.achiever.entity.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements IUserDao {

	public User findByLogin(String login) {
		User foundresult = null;
		try {
			foundresult = (User) entityManager
					.createNamedQuery("User.getByLogin", User.class)
					.setParameter("login", login).getSingleResult();
			return foundresult;
		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException e) {
			return null;
		}
	}

	public User findByEmail(String email) {
		User foundresult = null;
		try {
			foundresult = (User) entityManager
					.createNamedQuery("User.getByEmail", User.class)
					.setParameter("email", email).getSingleResult();
			return foundresult;
		} catch (PersistenceException e) {
			return null;
		}
	}

	@Override
	public void delete(User user) {
		user.setActive(0);
	}

	@Override
	public List<User> findIfActive(Class<User> classUser, int b,
			int studentCount) {
		List<User> foundNewResult = null;
		foundNewResult = entityManager
				.createNamedQuery("User.getByActiveAndStudentCount", User.class)
				.setParameter("studentCount", 0).setParameter("active", 0)
				.getResultList();
		return foundNewResult;
	}

	@Override
	public List<User> getAllByRole(Role role) {

		return entityManager.createNamedQuery("User.getAllByRole", User.class)
				.setParameter("role", role).getResultList();

	}

}
