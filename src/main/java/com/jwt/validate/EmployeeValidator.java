package com.jwt.validate;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.jwt.entity.Employee;
import com.jwt.exception.EmployeeDeptFormatException;
import com.jwt.exception.EmployeeIdFormatException;
import com.jwt.exception.EmployeeNameFormatException;
import com.jwt.service.EmployeeService;
import com.jwt.util.EmployeeUtil;

@Component
public class EmployeeValidator{// implements Validator {

	private boolean isEdit;
	
	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	@Autowired
	EmployeeUtil employeeUtil;
	
	@Autowired
	private EmployeeService service;
	
	/*
	 * @Override public boolean supports(Class<?> clazz) { return
	 * Employee.class.equals(clazz); }
	 * 
	 * @Override public void validate(Object target, Errors errors) {
	 */
	public void validate(Object target) {
		
		Employee employee = (Employee)target;
		if(StringUtils.isEmpty(employee.getEmpId())){
			throw new EmployeeIdFormatException("Employee id must be enter");
		}
		else if(!Pattern.compile("[0-9]{4,6}").matcher(employee.getEmpId().toString()).matches()){
			throw new EmployeeIdFormatException("Id must be 4-12 Digits Only");
		}
		if(!Pattern.compile("[a-zA-Z]{4,20}").matcher(employee.getName()).matches()) {
			throw new EmployeeNameFormatException( "Name only range of 4-20 accepted");
		}
		if(!employeeUtil.getEmployeeDeptTypes().contains(employee.getDept())) {
			throw new EmployeeDeptFormatException("Dept must be="+employeeUtil.getEmployeeDeptTypes());
		}
		
	}

	public void validateById(Long empId) {
		if(StringUtils.isEmpty(empId)){
			throw new EmployeeIdFormatException("Employee id must be enter");
		}
		else if(!Pattern.compile("[0-9]{4,6}").matcher(empId.toString()).matches()){
			throw new EmployeeIdFormatException("4-12 Digits Only");
		}
	}

	public void validateByName(String name) {
		// TODO Auto-generated method stub
		if(!Pattern.compile("[a-zA-Z]{4,20}").matcher(name).matches()) {
			throw new EmployeeNameFormatException( "Name only range of 4-20 accepted");
		}
		
	}
}
