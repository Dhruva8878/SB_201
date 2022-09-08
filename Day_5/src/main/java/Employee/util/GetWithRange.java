package Employee.util;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.Employee.Employee;
import com.Employee.EmployeeException;
import com.EmployeeDAO.EmployeeDAO;
import com.EmployeeDAO.EmployeeDAOImpl;

public class GetWithRange {
	
	public static void main(String[] args) throws EmployeeException  {
		
      EmployeeDAO emd=new EmployeeDAOImpl();
      Scanner sc=new Scanner(System.in);
      System.out.println("enter starting salary");
      int n1=sc.nextInt();
      System.out.println("Enter ending salary");
      int n2=sc.nextInt();
      
      
      
	try {
		 List<Employee> emp = emd.getAllEmployeeWithRangeSalary(n1, n2);
		
		 
		 emp.forEach(e->System.out.println(e));
	
	} catch (Exception e1) {
		throw new EmployeeException("Check the Query");
	}
      
     
      
		
	}

}
