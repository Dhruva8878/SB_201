package Utility;

import java.util.Scanner;

import com.DAO.EmployeeDao;
import com.daoImpl.EmployeeDaoImpl;

public class AccUpdate {
	
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
		
		
	}

}
