package Employee.util;

import java.util.Scanner;

import com.Employee.Employee;
import com.Employee.EmployeeException;

import EmployeeDAO.EmployeeDAO;
import EmployeeDAO.EmployeeDAOImpl;

public class UpdateEmployee {
	
	public static void main(String[] args) throws EmployeeException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee id");
		int id=sc.nextInt();
		System.out.println("Enter Employee name");
		String name=sc.next();
		System.out.println("Enter Employee address");
		String add=sc.next();
		System.out.println("Enter Employee salary");
		int sal=sc.nextInt();
		
		Employee employee=new Employee(id, name, add, sal);
		
		EmployeeDAO emp=new EmployeeDAOImpl();
		
		Employee  val= emp.updateEmployee(employee);
		
		System.out.println(val);
		
	}

}
