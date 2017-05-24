package com.course.exception;

public class CourseServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	private int status;

	public CourseServiceException(String message, int status) {
		super();
		this.message = message;
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
}
