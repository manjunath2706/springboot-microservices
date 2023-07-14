package com.microservices_example2.departmentservice.controller;

import java.util.ArrayList;
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

import com.microservices_example2.departmentservice.client.EmployeeClient;
import com.microservices_example2.departmentservice.model.Department;
import com.microservices_example2.departmentservice.repository.DapartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	private static Logger loggger=LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	private DapartmentRepository departmentRepo;	
	
	@Autowired
	private EmployeeClient employeeClient;
	
	@PostMapping("/addDepartment")
	public Department add(@RequestBody Department dept) {
		loggger.info("Department add: {}",dept);
		return departmentRepo.addDepartment(dept);
	}
	
	@GetMapping("/getDepartment")
	public List<Department> findAll(){
		loggger.info("Department find all");
		return departmentRepo.findAll();
	}
	
	@GetMapping("/getDepartmentById/{id}")
	public Department findById(@PathVariable Long id) {
		loggger.info("department find by : id={}",id);
		return departmentRepo.findById(id);
	}
	
	@GetMapping("/with-employees")
	public List<Department> findWithAllEmployees(){
		loggger.info("Department find");
		List<Department> departments=departmentRepo.findAll();
		departments.forEach(dept -> dept.setEmp(employeeClient.findEmployeesByDeptId(dept.getId())));
		return departments;
	}
}
