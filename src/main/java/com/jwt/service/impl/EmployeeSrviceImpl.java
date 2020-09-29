package com.jwt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.entity.Employee;
import com.jwt.repo.EmployeeRepository;
@Service
public class EmployeeSrviceImpl implements com.jwt.service.EmployeeService {

	@Autowired
	EmployeeRepository repo;
	@Override
	public List<Employee> getAll() {
		
		return repo.findAll();
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getById(Long empId) {
		Employee employee=repo.getOne(empId);
		
		return employee;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long save(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp).getEmpId();
	}

	@Override
	public void deleteById(Long empId) {
		// TODO Auto-generated method stub
		repo.deleteById(empId);
		
	}

	@Override
	public void update(Employee emp) {
		// TODO Auto-generated method stub
		repo.save(emp);
		
	}

	@Override
	public void updateUser(Employee emp) {
		// TODO Auto-generated method stub
		repo.save(emp);
		
	}

	@Override
	public Boolean isExit(Long empId) {
		// TODO Auto-generated method stub
		return repo.existsById(empId);
	}

	@Override
	public void updateName(Long empId, String name) {
		// TODO Auto-generated method stub
		repo.updateName( empId,  name);
	}

}
