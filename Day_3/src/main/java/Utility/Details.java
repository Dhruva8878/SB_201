package Utility;

import java.util.Scanner;

import com.DAO.EmployeeDao;
import com.daoImpl.EmployeeDaoImpl;

public class Details {
	
	public static void main(String[] args) {
		
		EmployeeDao emp=new EmployeeDaoImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee id");
		int id=sc.nextInt();
		
		String[] detail=emp.getNameAndAddress(id);
		
		System.out.println(detail[0]);
		System.out.println(detail[1]);
	}

}
