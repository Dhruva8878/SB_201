package Employee.util;

import java.util.Scanner;

import com.Employee.Employee;
import com.Employee.EmployeeException;

import EmployeeDAO.EmployeeDAO;
import EmployeeDAO.EmployeeDAOImpl;

public class GetEmployeeById {
	
	public static void main(String[] args) throws EmployeeException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee id");
		int id=sc.nextInt();
		
		EmployeeDAO emp=new EmployeeDAOImpl();
		
		Employee val= emp.getEmployeeById(id);
		
		System.out.println(val);
		
		
	}

}
