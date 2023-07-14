package com.microservices_example2.employeeservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices_example2.employeeservice.model.Employee;
import com.microservices_example2.employeeservice.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger loger=LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeRepository empRepo;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		loger.info("employee add : {}",employee );
		return empRepo.addEmployee(employee);
	}
	@GetMapping("/findAllEmployees")
	public List<Employee> findAllEmployee(){
		loger.info("find All employees");
		return empRepo.findAllEmployees();
	}
	@GetMapping("/findByEmployeeId/{id}")
	public Employee findEmployeeByEmpId(@PathVariable("id") Long id) {
		loger.info("find employee by id: {}",id);
		return empRepo.findByEmpId(id);
	}
	
	@GetMapping("/findEmployeesByDeptId/{departmentId}")
	public List<Employee> findEmployeesByDeptId(@PathVariable("departmentId") Long deptId) {
		loger.info("find employess by dept id: {}",deptId);
		return empRepo.findByDepartmentId(deptId);
	}
}
