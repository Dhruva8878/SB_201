package Employee.util;

import java.util.List;
import java.util.Scanner;

import com.Employee.Employee;
import com.Employee.EmployeeException;
import com.EmployeeDAO.EmployeeDAO;
import com.EmployeeDAO.EmployeeDAOImpl;

public class GetByAddress {
	
	public static void main(String[] args) throws EmployeeException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee Address");
		String add=sc.next();
		
		EmployeeDAO emd=new EmployeeDAOImpl();
		
		try {
			
			 List<Employee> addr=emd.getEmployeesByAddress(add);
			 addr.forEach(e->System.out.println(e));
			 
		} catch (Exception e) {
			throw new EmployeeException("Enter a Valid Address");
		}
	}

}
