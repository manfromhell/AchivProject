package com.ita.softserveinc.achiever.dao;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ita.softserveinc.achiever.entity.Topic;



public class TopicDaoTest extends TestCase {

	@Autowired
	private static ITopicDao topicDAO;
	private static Topic testing = new Topic("Basics");

	@Before
	public void setUp() throws Exception {
		topicDAO.create(testing);
	}
	
	@Test
	public void testCreate() {
		Topic tested = new Topic("Arrays");
		topicDAO.create(tested);
		assertEquals("Arrays", tested.getName());
	}

	@Test
	public void testUpdate() {
		testing.setName("Operators");
		topicDAO.update(testing);
		assertEquals("Operators", testing.getName());
	}

	@Test
	public void testDelete() {		
		topicDAO.delete(testing);
		Topic test = topicDAO.findByName("Basics");
		assertNull(test);
	}

	@Test
	public void testFindTopicByName() {
		Topic tested = topicDAO.findByName("Basics");
		assertEquals(testing, tested);
	}

	@Test
	public void testFindByID() {
		Long id = testing.getId();
		Topic tested = topicDAO.findById(Topic.class, id);
		Long testId = tested.getId();
		assertEquals(id, testId);
	}

	@Test
	public void testFindAll() {
		Topic aTest = new Topic("Arrays");
		topicDAO.create(aTest);
		List<Topic> tested = topicDAO.findAll(Topic.class);
		assertNotNull(tested);
	}
}
