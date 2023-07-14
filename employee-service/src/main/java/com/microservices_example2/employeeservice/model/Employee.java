package com.microservices_example2.employeeservice.model;

public record Employee(Long id,String name,Long departmentId,int age,String position) {

}
