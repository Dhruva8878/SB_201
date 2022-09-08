package Employee.util;

import java.util.Scanner;

import com.Employee.EmployeeException;
import com.EmployeeDAO.EmployeeDAO;
import com.EmployeeDAO.EmployeeDAOImpl;

public class GetNameAndSalary {
	
	public static void main(String[] args) throws EmployeeException {
		
		EmployeeDAO emd=new EmployeeDAOImpl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee Id");
		int id=sc.nextInt();
		
		try {
			
			Object[] obj=emd.getEmployeeNameAndSalary(id);
			
			String name= (String) obj[0];
			int sal= (Integer) obj[1];
			
			System.out.println("Employee name = "+ name);
			System.out.println("Employee salary = "+sal);
			
			
			
		} catch (Exception e) {
			throw new EmployeeException("Enter a valid Id");
		}
		
	}

}
