
package com.course.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.course.apputility.BeanConfig;
import com.course.model.Course;
import com.course.model.Enrollment;
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
			System.out.println("Name: " + student.getFirstName());
			System.out.println("ID: "+ student.getId());
			BeanConfig c = new BeanConfig();
			c.getSessionFactory().getCurrentSession().beginTransaction().begin();
			c.getSessionFactory().getCurrentSession().persist(student);
			c.getSessionFactory().getCurrentSession().beginTransaction().commit();
			System.out.println("Return Id: " + student.getId());
		} catch (Exception e) {
			logger.debug("Error: " + e.getMessage());
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<Student> getStudents() {
		List<Student> students = entityManager.createQuery("FROM STUDENT", Student.class).getResultList();
		return students;
	}

	@Override
	public List<Course> getCourses() {
		List<Course> courses = entityManager.createQuery("FROM COURSE", Course.class).getResultList();
		return courses;
	}

	@Override
	public Enrollment addEnrollment(Enrollment enrollment) {
		
		
		try {
			BeanConfig c = new BeanConfig();
			c.getSessionFactory().getCurrentSession().beginTransaction().begin();
			c.getSessionFactory().getCurrentSession().persist(enrollment);
			c.getSessionFactory().getCurrentSession().beginTransaction().commit();
		} catch (Exception e) {
			logger.debug("Error: " + e.getMessage());
			e.printStackTrace();
		}
		return enrollment;
	}
	
	@Override
	public List<Enrollment> getCourseEnrollment(int course_code) {
		List<Enrollment> enrollments = entityManager.createQuery("FROM COURSE where course_code="+course_code, Enrollment.class).getResultList();
		return enrollments;
	}
}
