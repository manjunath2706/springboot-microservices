package com.microservices_example2.departmentservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.microservices_example2.departmentservice.model.Department;

@Repository
public class DapartmentRepository {


	private List<Department> departments=new ArrayList<>();
	
	public Department addDepartment(Department dept) {
		departments.add(dept);
		return dept;
	}
	
	public Department findById(Long id) {
		return departments.stream().filter(dep -> dep.getId().equals(id)).findFirst().orElseThrow();
	}
	
	public List<Department> findAll(){
		return departments;
	}
}
