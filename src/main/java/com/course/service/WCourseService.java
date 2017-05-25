package com.course.service;

import java.util.List;

import com.course.model.Student;
import com.course.model.University;

public interface WCourseService {

	List<University> getUniversities();

	Student addStudent(Student student);

}
