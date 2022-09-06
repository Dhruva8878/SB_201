package com.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.DAO.EmployeeDao;
import com.Emplo.Demo;
import com.Emplo.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	
	@Override
	public void save(Employee emp) {
	EntityManager em=Demo.provideManager();
	
	em.getTransaction().begin();
	em.persist(emp);
	em.getTransaction().commit();
	
	System.out.println("added Successfully");
	
	em.close();
		
	}
	

	@Override
	public String getAddressOfEmployee(int empId) {
		String add="Not found...";
		
		EntityManager em=Demo.provideManager();
		
		 Employee emplo= em.find(Employee.class, empId);
		  
		 if(emplo!=null) {
			 add=emplo.getAddress();
		 }
		 else {
			 add="Employee Doesn't Exist";
		 }
		
		  em.close();
		return add;
	}

	@Override
	public String giveBonusToEmployee(int empId, int bonus) {
		String res="Not Updated";
		
		EntityManager em=Demo.provideManager();
		
		Employee emplo=em.find(Employee.class, empId);
		if(emplo!=null) {
			em.getTransaction().begin();
		     
			emplo.setSalary(emplo.getSalary()+bonus);
			
			em.getTransaction().commit();
			
			res="Successfully Added";
			
		}
		else {
			res="Employee Not Found";
		}
		
		
		em.close();
		return res;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		boolean ans=false;
		
		EntityManager em=Demo.provideManager();
		
		Employee employee=em.find(Employee.class, empId);
		
		if(employee!=null) {
			em.getTransaction().begin();
			
			em.remove(employee);
			
			em.getTransaction().commit();
			
			ans=true;
		}
		else {
			ans=false;
		}
		
		em.close();		
		return ans;
	}

	@Override
	public String[] getNameAndAddress(int empId) {
		String[] ans= {null,null};
		
		EntityManager em=Demo.provideManager();
		
		Employee emplo=em.find(Employee.class, empId);
		
		if(emplo!=null) {
			
			ans[0]=emplo.getName();
			ans[1]=emplo.getAddress();
		}
		
		em.close();
		return ans;
	}

	

}
