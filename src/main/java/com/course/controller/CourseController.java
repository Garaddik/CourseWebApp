package com.course.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.course.model.Course;
import com.course.model.Student;
import com.course.model.University;
import com.course.service.WCourseService;
import com.course.service.WCourseServiceImpl;
import com.course.validator.LoginValidator;

@Controller
public class CourseController {

	
	WCourseService service = new WCourseServiceImpl();

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
	public ModelAndView adStudent(@ModelAttribute("student") Student student,Model model, HttpSession session, HttpServletResponse response,
			HttpServletRequest request) {
		
		Student studentResponse = service.addStudent(student);
		
		ModelAndView view = new ModelAndView("students","student",new ArrayList<Student>());
		return view;
	}
	
	@RequestMapping(value = "/students")
	public ModelAndView students(Model model, HttpSession session, HttpServletResponse response,
			HttpServletRequest request) {
		ModelAndView view = new ModelAndView("students","student",new ArrayList<Student>());
		return view;
	}
	
	@RequestMapping(value = "/courses")
	public ModelAndView Courses(@RequestParam("university") String universityName,Model model, HttpSession session, HttpServletResponse response,
			HttpServletRequest request) {
	
		ModelAndView view = new ModelAndView("courses");
		request.setAttribute("courses",new ArrayList<Course>());
		request.setAttribute("university", universityName);
		return view;
	
	}
	
}
