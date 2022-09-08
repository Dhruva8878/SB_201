package com.EmployeeDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.Employee.Demo;
import com.Employee.Employee;
import com.Employee.EmployeeException;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public List<Employee> getAllEmployees() throws EmployeeException {
		
		EntityManager em=Demo.provideManager();
		
		String jpql="from Employee";
		
		Query q= em.createQuery(jpql);
		
		return q.getResultList();
	}

	@Override
	public List<Employee> getEmployeesByAddress(String address) throws EmployeeException {
		
		EntityManager em=Demo.provideManager();
		
		String jpql="from Employee where address =:adr";
		
		Query q=em.createQuery(jpql);
		q.setParameter("adr", address);
		
		return q.getResultList();
	}

	@Override
	public List<Employee> getAllEmployeeWithRangeSalary(int startSalary, int endSalary) throws EmployeeException {
		
		EntityManager em=Demo.provideManager();
		
		String jpql="from Employee where salary between :st and :ed";
		
		Query q=em.createQuery(jpql);
		q.setParameter("st", startSalary);
		q.setParameter("ed", endSalary);
		
		return q.getResultList();
	}

	@Override
	public Object[] getEmployeeNameAndSalary(int empId) throws EmployeeException {
		
		EntityManager em=Demo.provideManager();
		
		String jpql="select name, salary from Employee where id=:ID";
		
		TypedQuery<Object[]> tq=em.createQuery(jpql,Object[].class);
		tq.setParameter("ID", empId);
		
		Object[] obj= tq.getSingleResult();
		
		return obj;
	}

	@Override
	public int getEmployeeSalaryById(int empId) throws EmployeeException {
		
		EntityManager em=Demo.provideManager();
		
		String jpql="select salary from Employee where id=:ID";
		
		TypedQuery<Integer> tq=em.createQuery(jpql,Integer.class);
		tq.setParameter("ID", empId);
		
		int sal=tq.getSingleResult();
		
		return sal;
	}
	
	

}
