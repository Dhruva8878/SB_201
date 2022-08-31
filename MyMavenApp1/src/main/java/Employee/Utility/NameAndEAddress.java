package Employee.Utility;

import com.Employee.DAO.EmployeeDAO;
import com.Employee.Impl.EmployeeDAOImpl;

import Employee.Excepton.InvalidEmployeeException;

public class NameAndEAddress {
	
	public static void main(String[] args) throws InvalidEmployeeException {
		
		EmployeeDAO emp=new EmployeeDAOImpl();
		String[] ans=emp.getNameAndAddress(3);
		
		System.out.println("name -"+ans[0]+" address -"+ans[1]);
	}

}
