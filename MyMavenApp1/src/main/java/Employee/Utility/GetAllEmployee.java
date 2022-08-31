package Employee.Utility;

import java.util.ArrayList;
import java.util.List;

import com.Employee.DAO.EmployeeDAO;
import com.Employee.Impl.EmployeeDAOImpl;
import com.Employee.detail.Employee;

public class GetAllEmployee {
	
	public static void main(String[] args) {
		
		
		EmployeeDAO emplo=new EmployeeDAOImpl();
		
		List<Employee> emp=emplo.getAllEmployee();
		
		emp.forEach(e->System.out.println(e));
		
		
	}

}
