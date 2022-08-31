package com.Employee.DAO;

import java.util.List;

import com.Employee.detail.Employee;

import Employee.Excepton.InvalidEmployeeException;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmployee();
	
	public String getAddressOfEmployee(int empId) throws InvalidEmployeeException;
	
	public String giveBonusToEmployee(int empId, int bonus) throws InvalidEmployeeException;
	
	public boolean deleteEmployee(int empId) throws InvalidEmployeeException;
	
	public String[] getNameAndAddress(int empId) throws InvalidEmployeeException;

}
