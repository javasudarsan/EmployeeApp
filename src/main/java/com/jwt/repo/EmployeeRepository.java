package com.jwt.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jwt.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>,CrudRepository<Employee, Long>{

	@Transactional
	@Modifying
	@Query("update Employee e set e.name = :name where e.empId = :empId")
	void updateName(@Param(value="empId")Long empId, @Param(value="name")String name);

}
