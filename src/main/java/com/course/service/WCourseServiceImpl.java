package com.course.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.course.apputility.AppConstants;
import com.course.dao.WCourseDAO;
import com.course.model.Course;
import com.course.model.Enrollment;
import com.course.model.Student;
import com.course.model.University;
import com.google.gson.Gson;

@Component
@Repository
@Qualifier("service")
public class WCourseServiceImpl implements WCourseService {

	@Autowired
	WCourseDAO dao ;

	@Override
	public List<University> getUniversities() {

		String response = getHttpResponse();
		Gson gson = new Gson();
		University[] univs = (University[]) gson.fromJson(response, University[].class);

		return Arrays.asList(univs);
	}

	public String getHttpResponse() {
		StringBuilder result = new StringBuilder();
		URL url = null;
		try {
			url = new URL(AppConstants.UNIVERSITY_ENDPOINT_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	@Override
	public Student addStudent(Student student) {

		Student studentResponse = dao.addStudent(student);
		return studentResponse;
	}

	@Override
	public List<Student> getStudents() {
		List<Student> students = dao.getStudents();
		return students;
	}

	@Override
	public List<Course> getCourses() {
		List<Course> courses = dao.getCourses();
		return courses;
	}

	@Override
	public Enrollment addEnrollment(Enrollment enrollment) {

		Enrollment enrollmentresponse = dao.addEnrollment(enrollment);
		return enrollmentresponse;
	}
	
	@Override
	public List<Enrollment> getCourseEnrollments(int course_code) {
		List<Enrollment> enrollemts = dao.getCourseEnrollment(course_code);
		return enrollemts;
	}
}