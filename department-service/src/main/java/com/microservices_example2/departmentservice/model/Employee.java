package com.microservices_example2.departmentservice.model;

public record Employee(Long id,String name,Long departmentId,int age,String position) {

}
