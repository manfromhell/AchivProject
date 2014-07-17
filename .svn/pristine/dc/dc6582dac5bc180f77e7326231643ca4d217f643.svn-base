package com.ita.softserveinc.achiever.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ita.softserveinc.achiever.entity.Direction;
import com.ita.softserveinc.achiever.entity.Group;

@Repository
public class GroupDaoImpl extends GenericDaoImpl<Group> implements IGroupDao {
	private static final Logger LOG = Logger.getLogger(GroupDaoImpl.class);

	@Override
	public List<Group> findByName(String name) {
		List<Group> groups = null;
		try {
			groups = entityManager
					.createNamedQuery("Group.findByName", Group.class)
					.setParameter("name", name).getResultList();

		} catch (NoResultException e) {
			LOG.info("No one group with this name was found");
			return null;
		}
		return groups;
	}

	@Override
	public List<Group> findByDirection(Direction direction) {
		List<Group> groups = new ArrayList<Group>();
		try {
			groups = entityManager
					.createNamedQuery("Group.findByDirection", Group.class)
					.setParameter("direction", direction).getResultList();

		} catch (NoResultException e) {
			LOG.info("No one group in this direction were found");
			return null;

		}
		return groups;

	}

	@Override
	public boolean isUnique(Group group) {
		try {
				entityManager
					.createNamedQuery("Group.getUnique", Group.class)
					.setParameter("groupName", group.getGroupName())
					.setParameter("direction", group.getDirection())
					.getSingleResult();
		} catch (NoResultException e) {
			LOG.info("No one group with this name was found");
			return true;
		}
		return false;
	}

}
