package com.DAO;


import com.Emplo.Employee;

public interface EmployeeDao {
	
	public void save(Employee emp);
	
	public String getAddressOfEmployee(int empId);
	
	public String giveBonusToEmployee(int empId, int bonus);
	
	public boolean deleteEmployee(int empId);
	
	public String[] getNameAndAddress(int empId);

}
