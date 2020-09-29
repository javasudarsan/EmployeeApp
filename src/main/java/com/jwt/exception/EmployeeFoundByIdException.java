package com.jwt.exception;

public class EmployeeFoundByIdException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public EmployeeFoundByIdException(String msg) {
		super(msg);
	}
}
