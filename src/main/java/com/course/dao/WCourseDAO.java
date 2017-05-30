package com.course.dao;

import java.util.List;

import com.course.model.Course;
import com.course.model.Enrollment;
import com.course.model.Student;

public interface WCourseDAO {

	Student addStudent(Student student);

	List<Student> getStudents();

	List<Course> getCourses();

	Enrollment addEnrollment(Enrollment enrollment);

	public List<Enrollment> getCourseEnrollment(int course_code);
}
