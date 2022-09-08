package Employee.util;

import java.util.List;

import com.Employee.Employee;
import com.Employee.EmployeeException;
import com.EmployeeDAO.EmployeeDAO;
import com.EmployeeDAO.EmployeeDAOImpl;

public class GetAllEmployees {
	
	public static void main(String[] args) throws EmployeeException {
		
		EmployeeDAO emd=new EmployeeDAOImpl();
		
		try {
			List<Employee> em= emd.getAllEmployees();
			
			em.forEach(e->System.out.println(e));
			
			
		} catch (Exception e) {
			throw new EmployeeException("Please check the query");
		}
		
	}

}
