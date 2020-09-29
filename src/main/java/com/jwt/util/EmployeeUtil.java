package com.jwt.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class EmployeeUtil {
public List<String> getEmployeeDeptTypes(){
		
		return Arrays.asList("IT","FANANCE","SUPPORT");
		
		/*
		 * List<String> list = new ArrayList<String>(); list.add("IT");
		 * list.add("FANANCE"); list.add("SUPPORT"); return list;
		 */
		
	}
}
