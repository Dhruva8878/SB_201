package Employee.util;

import java.util.Scanner;

import com.Employee.EmployeeException;
import com.EmployeeDAO.EmployeeDAO;
import com.EmployeeDAO.EmployeeDAOImpl;

public class GetSalaryById {
	
	public static void main(String[] args) throws EmployeeException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee id");
		int id=sc.nextInt();
	    
		EmployeeDAO emd=new EmployeeDAOImpl();
		
		try {
			int sal=emd.getEmployeeSalaryById(id);
			
			System.out.println("Employee salary - "+sal);
			
			
		} catch (Exception e) {
			throw new EmployeeException("Enter a valid id");
		}
	}

}
