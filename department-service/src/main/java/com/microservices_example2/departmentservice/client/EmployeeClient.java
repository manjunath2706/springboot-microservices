package com.microservices_example2.departmentservice.client;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.microservices_example2.departmentservice.model.Employee;



@HttpExchange
public interface EmployeeClient {
	
	@GetExchange("/employee/findEmployeesByDeptId/{departmentId}")
	public List<Employee> findEmployeesByDeptId(@PathVariable("departmentId") Long deptId);

}
