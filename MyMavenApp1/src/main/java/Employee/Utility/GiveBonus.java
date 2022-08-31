package Employee.Utility;

import com.Employee.DAO.EmployeeDAO;
import com.Employee.Impl.EmployeeDAOImpl;

import Employee.Excepton.InvalidEmployeeException;

public class GiveBonus {
	
	public static void main(String[] args) throws InvalidEmployeeException {
		
		EmployeeDAO emp=new EmployeeDAOImpl();
		
		String s=emp.giveBonusToEmployee(1, 500);
	
		System.out.println(s);
	
	}

}
