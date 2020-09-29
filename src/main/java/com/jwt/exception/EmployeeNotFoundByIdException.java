package com.jwt.exception;

public class EmployeeNotFoundByIdException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public EmployeeNotFoundByIdException(String msg) {
		super(msg);
	}
	
	
}
