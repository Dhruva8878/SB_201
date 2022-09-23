package com.masai;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
	
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Welcome to Spring Boot";
	}
	
	
	@GetMapping(value="/employee")
	public Employee getEmployee() {
		Employee emp=new Employee(1, "Ram","Indore", 25000);
		return emp;
	}
	
	
	@GetMapping(value="/employees" )
	public List<Employee> getAllEmployees(){
		List<Employee> emps=new ArrayList<>();
		
		emps.add(new Employee(1,"Ram","indore",25000));
		emps.add(new Employee(2, "Sita", "khargone", 56330));
		emps.add(new Employee(3, "krihsna", "pune", 3450));
		
		return emps;
	}
	

}
