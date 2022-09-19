package ass_1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

@Service
public class EmployeeImpl implements EmployeeService{

	@Override
	public boolean saveEmployee(Employee emp) {
		boolean val=false;
		
		EntityManager em=EMUtil.provideManager();
		
		em.getTransaction().begin();
		
		em.persist(emp);
		val=true;
		
		em.getTransaction().commit();
		
		em.close();
		
		return val;
	}

	@Override
	public List getAllEmployee() {
		List<Employee> list=new ArrayList<>();
		
		EntityManager em=EMUtil.provideManager();
		String jpql="from Employee";
		
		Query q= em.createQuery(jpql);
		
		list=q.getResultList();
		
		em.close();
		return list;
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeException {
		Employee emp=null;
		
		EntityManager em=EMUtil.provideManager();
		
		Employee employee=em.find(Employee.class, empId);
		
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
	public String deleteEmployeeById(int empId) throws EmployeeException {
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
			throw new EmployeeException("Employee Not Found");
		}
		
		em.close();
		return msg;
	}
	
	

}
