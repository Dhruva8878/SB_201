package EmployeeDAO;

import javax.persistence.EntityManager;

import com.Employee.Demo;
import com.Employee.Employee;
import com.Employee.EmployeeException;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public Employee registerEmployee(Employee employee) throws EmployeeException {
		
		Employee emp=null;
		
		EntityManager em=Demo.provideManager();
		
		em.getTransaction().begin();
		
		if(employee.getAddress().equals(null) ||employee.getName().equals(null) || employee.getSalary()==0) {
			
			throw new EmployeeException("Please Fill All the Fields");
		}
		else {
			em.persist(employee);
			emp=employee;
		}
		em.getTransaction().commit();
		
		em.close();

		return emp;
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeException {
		Employee emp=null;
		
		EntityManager em=Demo.provideManager();
		
		Employee employee= em.find(Employee.class, empId);
		
		if(employee!=null) {
			emp=employee;
		}
		else {
			throw new EmployeeException("Employee Not Found");
		}
		
		em.close();
		
		return emp;
	}

	@Override
	public Employee deleteEmployeeById(int empId) throws EmployeeException {
		Employee val=null;
		
		EntityManager em=Demo.provideManager();
		
	 	Employee emp= em.find(Employee.class, empId);
	 	
	 	if(emp!=null) {
	 		
	 		em.getTransaction().begin();
	 		
	 		em.remove(emp);
	 		val=emp;
	 		
	 		em.getTransaction().commit();
	 		
	 	}
	 	else {
	 		throw new EmployeeException("Employee Not Found");
	 	}
		
		em.close();
		return val;
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		Employee val=null;
		
		EntityManager em=Demo.provideManager();
		
		Employee emp=em.find(Employee.class, employee.getId());
		
		if(emp!=null) {
			
			em.getTransaction().begin();
			
			em.merge(employee);
			val=employee;
			
			em.getTransaction().commit();
		}
		else {
			throw new EmployeeException("Employee Not Found");
		}
		
		
		return val;
	}
	
	
	

}
