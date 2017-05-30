package com.course.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.course.model.Course;
import com.course.model.Enrollment;
import com.course.model.Student;
import com.course.model.University;
import com.course.service.WCourseService;
import com.course.validator.LoginValidator;

@Controller
public class CourseController {

	@Autowired
	WCourseService service;

	LoginValidator validator = new LoginValidator();

	@RequestMapping(value = "/")
	public ModelAndView index(Model model, HttpSession session, HttpServletResponse response,
			HttpServletRequest request) {

		List<University> universities = service.getUniversities();
		request.setAttribute("universities", universities);
		ModelAndView view = new ModelAndView("home");
		view.setViewName("home");
		return view;
	}

	@RequestMapping(value = "/studentform")
	public ModelAndView studentform(Model model, HttpSession session, HttpServletResponse response,
			HttpServletRequest request) {
		ModelAndView view = new ModelAndView("studentform", "student", new Student());
		return view;
	}

	@RequestMapping(value = "/addstudent")
	public ModelAndView adStudent(@ModelAttribute("student") Student student, Model model, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) throws IOException {

		Student studentResponse = service.addStudent(student);
		
		if(studentResponse.getId() != 0){
			response.sendRedirect(request.getContextPath() + "/students");
		}
		ModelAndView view = new ModelAndView("studentform", "student",studentResponse);
		return view;
	}

	@RequestMapping(value = "/students")
	public ModelAndView students(Model model, HttpSession session, HttpServletResponse response,
			HttpServletRequest request) {
		List<Student> students = service.getStudents();
		ModelAndView view = new ModelAndView("students","students",students);
		return view;
	}

	@RequestMapping(value = "/courses")
	public ModelAndView Courses(@RequestParam("university") String universityName, Model model, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {

		List<Course> courses = service.getCourses();
		
		ModelAndView view = new ModelAndView("courses");
		request.setAttribute("courses", courses);
		request.setAttribute("university", universityName);
		return view;
	}
	
	@RequestMapping(value = "/enrollment")
	public ModelAndView Courses(@RequestParam("studentId") String studentId,@RequestParam("course_code") String course_code, Model model, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		Enrollment enrollment = new Enrollment();
		enrollment.setStudentId(studentId);
		enrollment.setCourse_code(course_code);
		Enrollment enrollmentResponse = service.addEnrollment(enrollment);

		if(enrollmentResponse.getEnrollmentId() != 0){
			response.sendRedirect(request.getContextPath() + "/enrollmets?course_code="+course_code);
		}
		ModelAndView view = new ModelAndView("studentform", "student",enrollment);
		return view;
	}
	
	@RequestMapping(value = "/enrollmets")
	public ModelAndView Courses(@RequestParam("course_code") Integer course_code, Model model, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {

		List<Enrollment> enrollments = service.getCourseEnrollments(course_code);
		
		ModelAndView view = new ModelAndView("enrollments");
		request.setAttribute("enrollments", enrollments);
		return view;
	}

}
