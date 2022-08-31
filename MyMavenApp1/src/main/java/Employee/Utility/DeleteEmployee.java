package Employee.Utility;

import com.Employee.DAO.EmployeeDAO;
import com.Employee.Impl.EmployeeDAOImpl;

import Employee.Excepton.InvalidEmployeeException;

public class DeleteEmployee {

	public static void main(String[] args) throws InvalidEmployeeException {
		
		EmployeeDAO emp=new EmployeeDAOImpl();
		
		boolean msg=emp.deleteEmployee(2);
		
		if(msg) {
			System.out.println("deleted Successfully");
		}
		else {
			System.out.println("Not Updated");
		}
	}
}
