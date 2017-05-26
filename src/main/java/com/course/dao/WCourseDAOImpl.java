
package com.course.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.course.model.Student;

@Transactional
@Repository
public class WCourseDAOImpl implements WCourseDAO {
	private static final Logger logger = LoggerFactory.getLogger(WCourseDAOImpl.class);
	
	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Override
	public Student addStudent(Student student) {
		
		try {
			entityManager.persist(student);
		} catch (Exception e) {
			logger.debug("Error: " + e.getMessage());
			e.printStackTrace();
		}
		return student;
	}
}
