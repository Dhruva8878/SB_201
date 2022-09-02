package Utility;

import java.util.List;
import java.util.Scanner;

import com.DAO.EmployeeDao;
import com.Emplo.Employee;
import com.daoImpl.EmployeeDaoImpl;

public class Insert_Employee {
	
	public static void main(String[] args) {
		
		EmployeeDao emp=new EmployeeDaoImpl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee id");
		int id=sc.nextInt();
		System.out.println("Enter Employee name");
		String name=sc.next();
		System.out.println("Enter Employee Address");
		String add=sc.next();
		System.out.println("Enter Employee salary");
		int sal=sc.nextInt();
		
		Employee employee=new Employee(id, name, add, sal);
		
		emp.save(employee);
		
		
		
		
		
	}

}
