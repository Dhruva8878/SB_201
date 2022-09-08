package com.EmployeeDAO;

import java.util.List;

import com.Employee.Employee;
import com.Employee.EmployeeException;

public interface EmployeeDAO {
	
	
	public List<Employee> getAllEmployees() throws EmployeeException;
	
	public List<Employee> getEmployeesByAddress(String address) throws EmployeeException;
	
	public List<Employee> getAllEmployeeWithRangeSalary(int startSalary,int endSalary) throws EmployeeException;
	
	public Object[] getEmployeeNameAndSalary(int empId) throws EmployeeException;
	
	public int getEmployeeSalaryById(int empId) throws EmployeeException;
	

}
