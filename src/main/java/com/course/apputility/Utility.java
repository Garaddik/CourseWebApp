package com.course.apputility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.course.exception.CourseServiceException;

public class Utility {

	private static final Logger logger = LoggerFactory.getLogger(Utility.class);

	static SimpleDateFormat formToISO = new SimpleDateFormat("M/d/yyyy hh:mm a");
	static SimpleDateFormat ISOToSTRING = new SimpleDateFormat("dd-MM-yyyy");

	public static Date convertToISODate(String dateValue) throws CourseServiceException {
		Date date;
		try {
			System.out.println("purchase Date: " + dateValue);
			date = formToISO.parse(dateValue);
		} catch (ParseException e) {
			throw new CourseServiceException(e.getMessage(), 500);
		}
		return date;
	}

	public static String convertISOToString(Date date) {
		String dateresponse = null;
		dateresponse = ISOToSTRING.format(date);
		return dateresponse;
	}
}
