package com.microservices_example2.departmentservice.model;

import java.util.ArrayList;
import java.util.List;

public class Department {

	private Long id;
	private String name;
	private List<Employee> emp=new ArrayList();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmp() {
		return emp;
	}
	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	public Department(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", emp=" + emp + "]";
	}
	
	
}
