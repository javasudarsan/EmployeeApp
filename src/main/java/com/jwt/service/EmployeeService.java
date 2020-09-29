package com.jwt.service;

import java.util.List;

import com.jwt.entity.Employee;

public interface EmployeeService {
	public List<Employee> getAll();

	public Employee getById(Long empId);

	public Long save(Employee emp);

	public void deleteById(Long empId);

	public void update(Employee emp);
	
	public void updateUser(Employee emp);
	
	public Boolean isExit(Long empId);

	public void updateName(Long empId, String name);
	

}
