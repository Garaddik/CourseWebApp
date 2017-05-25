
package com.course.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.course.model.Student;

@Component
public class WCourseDAOImpl implements WCourseDAO {
	private static final Logger logger = LoggerFactory.getLogger(WCourseDAOImpl.class);
	@Autowired 
	private SessionFactory sessionFactory;

	@Override
	public Student addStudent(Student student) {
		
		try {
			sessionFactory.getCurrentSession().beginTransaction().begin();
			sessionFactory.getCurrentSession().persist(student);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			logger.debug("Error: " + e.getMessage());
			e.printStackTrace();
		}
		return student;
	}
	
	public static void main(String[] args) {
		WCourseDAOImpl d = new WCourseDAOImpl();
		Student s = new Student();
		s.setFirstName("Kirya");
		d.addStudent(s);
		
	}

}
