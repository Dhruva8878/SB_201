package Employee.util;

import java.util.Scanner;

import com.Employee.Employee;
import com.Employee.EmployeeException;

import EmployeeDAO.EmployeeDAO;
import EmployeeDAO.EmployeeDAOImpl;

public class RegisterEmployee {
	
	
	public static void main(String[] args) throws EmployeeException {
		
		EmployeeDAO emp=new EmployeeDAOImpl();
		Employee employee=new Employee();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter EMployee Name");
		employee.setName(sc.next());
		System.out.println("Enter Employee Address");
		employee.setAddress(sc.next());
		System.out.println("Enter Employee salary");
		employee.setSalary(sc.nextInt());
		
		
		Employee val= emp.registerEmployee(employee);
		
		
		System.out.println(val);
		
	}

}
