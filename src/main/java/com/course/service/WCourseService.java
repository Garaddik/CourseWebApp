package com.course.service;

import java.util.List;

import com.course.model.Course;
import com.course.model.Enrollment;
import com.course.model.Student;
import com.course.model.University;

public interface WCourseService {

	List<University> getUniversities();

	Student addStudent(Student student);

	List<Student> getStudents();

	List<Course> getCourses();

	Enrollment addEnrollment(Enrollment enrollment);
	
	public List<Enrollment> getCourseEnrollments(int course_code);
}
