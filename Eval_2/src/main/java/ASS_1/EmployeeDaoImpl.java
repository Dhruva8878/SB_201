package ASS_1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import EntityUtil.Util;

public class EmployeeDaoImpl implements EmployeeDAO {

	@Override
	public void addDepartment(Department dept) {
	
		EntityManager em=Util.provideManager();
		
		em.getTransaction().begin();
		
		em.persist(dept);
		
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Department Added");
		
	}

	@Override
	public void addEmployee(Employee emp) {
		
		EntityManager em=Util.provideManager();
		
		em.getTransaction().begin();
		
		em.persist(emp);
		
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Employee added");
		
	}

	@Override
	public void registerEmployeeTODepartment(int empId, int deptId) throws EmployeeException, DepartmentException {
		
		EntityManager em=Util.provideManager();
		Department dp=em.find(Department.class, empId);
		Employee emp=em.find(Employee.class, deptId);
		
		dp.getEmplo().add(emp);
		
		em.getTransaction().begin();
		
		em.persist(dp);
		
         em.getTransaction().commit();
         
         em.close();
         
         System.out.println("Mapped Successfully");
	}

	@Override
	public List<Employee> getAllEmployeeWithDeptName(String deptName) throws EmployeeException {
		
		List<Employee> emp=null;
		
		EntityManager em=Util.provideManager();
		
		String jpql="from Employee where deptName=:dp";
		
		Query q=em.createQuery(jpql);
		
		q.setParameter("dp", deptName);
		
		emp=q.getResultList();
		
		return emp;
	}

	@Override
	public Department getDepartmentDetailsByEmployeeId(int empId) throws DepartmentException {
       
		Department dp=null;
		
		EntityManager em=Util.provideManager();
		
		Employee emp=em.find(Employee.class, empId);
		
			if(emp!=null) {
				dp=emp.getDep();
			}
			else {
				throw new DepartmentException("Employee Not Found");
			}
		
		return dp;
	}

	
	
}
