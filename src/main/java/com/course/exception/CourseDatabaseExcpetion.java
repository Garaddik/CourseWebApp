package com.course.exception;

public class CourseDatabaseExcpetion  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private int status;

	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}

	public CourseDatabaseExcpetion(int status,String message) {
		super();
		this.message = message;
		this.status = status;
	}
	
}
