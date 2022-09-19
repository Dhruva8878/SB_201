package ass_1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {

	@Override
	public boolean insertEmployeeDetails(Employee emp) {
		
		boolean msg=false;
		
		EntityManager em=EMUtil.provideManager();
		
		em.getTransaction().begin();
		
		em.persist(emp);
         msg=true;
		em.getTransaction().commit();
		
		em.close();
		return msg;
	}

	@Override
	public List getAllEmployeeDetails() {
		List<Employee> list=new ArrayList<>(); 
		
		EntityManager em=EMUtil.provideManager();
		
		String jpql="from Employee";
		
		Query q=em.createQuery(jpql);
		
         list=q.getResultList();
		
		
		em.close();
		return list;
	}

	@Override
	public Employee findEmployee(int empId) {
		Employee emp=null;
		
		EntityManager em=EMUtil.provideManager();
		
		emp= em.find(Employee.class, empId);
		
		em.close();
		return emp;
	}

	@Override
	public String deleteEmployeeDetailsById(int empId) {
		String msg="Not Changed";
		
	       EntityManager em=EMUtil.provideManager();
			
			Employee employee=em.find(Employee.class, empId);
			
			if(employee!=null) {
	           String jpql="delete from Employee where empId=:id";
				
				Query q= em.createQuery(jpql);
				q.setParameter("id", empId);
				msg="Deleted Successfully";
			}
			else {
				msg="Not Found";
			}
			
			
			em.close();
		return msg;
	}
	
	

}
