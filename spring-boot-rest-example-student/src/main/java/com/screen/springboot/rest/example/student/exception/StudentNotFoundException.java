package com.screen.springboot.rest.example.student.exception;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(String message, Throwable exception) {
		super(message, exception);
	}

}
