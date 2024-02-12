package com.example.crud.exception;

import lombok.Data;

@Data
public class ProjectAlreadyAssignmentException extends RuntimeException {


	public ProjectAlreadyAssignmentException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectAlreadyAssignmentException(String message) {
		
		
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
