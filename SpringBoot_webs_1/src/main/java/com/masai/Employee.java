package com.masai;

import org.springframework.stereotype.Service;

public class Employee {
	
	
	private Integer id;
	private String name;
	private String address;
	private Integer salary;
	
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}



	public Employee(Integer id, String name, String address, Integer salary) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Integer getSalary() {
		return salary;
	}



	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	
	

}
