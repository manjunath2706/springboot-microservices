package com.microservices_example2.employeeservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.microservices_example2.employeeservice.model.Employee;

@Repository
public class EmployeeRepository {
	
	private List<Employee> employees=new ArrayList<>();
	
	
	public Employee addEmployee(Employee emp) {
		employees.add(emp);
		return emp;
	}

	public List<Employee> findAllEmployees() {
		return employees;
	}
	
	public Employee findByEmpId(Long id) {
		return employees.stream().filter(emp -> emp.id().equals(id)).findFirst().orElseThrow();
	}
	
	public List<Employee> findByDepartmentId(Long deptId){
		return employees.stream().filter(e -> e.departmentId().equals(deptId)).toList();
	}
}
