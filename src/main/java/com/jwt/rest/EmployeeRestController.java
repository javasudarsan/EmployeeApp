package com.jwt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.entity.Employee;
import com.jwt.exception.EmployeeFoundByIdException;
import com.jwt.exception.EmployeeNotFoundByIdException;
import com.jwt.exception.EmployeeNotFoundException;
import com.jwt.service.EmployeeService;
import com.jwt.validate.EmployeeValidator;

@RestController
@RequestMapping("/rest")
public class EmployeeRestController {

	@Autowired
	EmployeeService service;
	
	@Autowired
	EmployeeValidator validate;

	@GetMapping("/getObj")
	public ResponseEntity<Employee> getObj() {

		return ResponseEntity.ok().body(new Employee());

	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/employees")
	public ResponseEntity<?> getAllEmployee() {

		List<Employee> employees = service.getAll();
		if (employees.isEmpty()) {

			throw new EmployeeNotFoundException("no employee data found");
			/*
			 * String msg="no employee data found"; return ResponseEntity.ok().body(msg);
			 */
		} else {
			return ResponseEntity.ok().body(employees);
		}

	}
	 @PreAuthorize("hasRole('USER')")
	@GetMapping("/getEmployeeById/{empId}")
	public ResponseEntity<Employee> getAllEmployee(@PathVariable Long empId) {
		boolean isExit = service.isExit(empId);
		validate.validateById(empId);
		if (!isExit) {
			throw new EmployeeNotFoundByIdException("Employee is not exist by this id=" + empId);
		} else {
			Employee employee = service.getById(empId);
			return ResponseEntity.ok().body(employee);
		}
	}
	 @PreAuthorize("hasRole('USER')")
	@PostMapping("/saveEmployee")
	public ResponseEntity<?> getAllEmployee(@RequestBody Employee emp) {
		validate.validate(emp);
		boolean isExit = service.isExit(emp.getEmpId());
		if (isExit) {
			throw new EmployeeFoundByIdException("Employee already exist by this id=" + emp.getEmpId());
		} else {
			Long id = service.save(emp);
			return ResponseEntity.ok("Employee succeessfull add by id=" + id);
		}
	}
	 @PreAuthorize("hasRole('USER')")
	@DeleteMapping("/deleteEmployee/{empId}")
	public ResponseEntity<?> employeeDeleteById(@PathVariable Long empId) {
		validate.validateById(empId);
		boolean isExit = service.isExit(empId);
		if (!isExit) {
			throw new EmployeeNotFoundByIdException("Employe not found by this id=" + empId);
		} else {
			service.deleteById(empId);
			return ResponseEntity.ok("Employee deleted succeessfull");
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Employee emp) {
		service.update(emp);
		return ResponseEntity.ok().body("Employee record updated successfully");
	}
	 @PreAuthorize("hasRole('USER')")
	@PatchMapping("/updateName/{empId}")
	public ResponseEntity<?> updateUser(@PathVariable Long empId,@RequestBody Employee emp) {
		validate.validateById(empId);
		validate.validateByName(emp.getName());
		boolean isExit = service.isExit(empId);
		if (!isExit) {
			throw new EmployeeNotFoundByIdException("Employe not found by this id=" + empId);
		} else {
			
			service.updateName(empId,emp.getName());
			return ResponseEntity.ok("Employee updated succeessfull");
		}
	}

}
