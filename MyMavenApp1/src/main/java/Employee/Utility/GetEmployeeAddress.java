package Employee.Utility;

import com.Employee.DAO.EmployeeDAO;
import com.Employee.Impl.EmployeeDAOImpl;

import Employee.Excepton.InvalidEmployeeException;

public class GetEmployeeAddress {
	
	public static void main(String[] args) throws InvalidEmployeeException {
		
		EmployeeDAO emp=new EmployeeDAOImpl();
		 
		String res=emp.getAddressOfEmployee(2);
		
		System.out.println(res);
	}

}
