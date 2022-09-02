package Utility;

import java.util.Scanner;

import com.DAO.EmployeeDao;
import com.daoImpl.EmployeeDaoImpl;

public class GetAddress {
	
	public static void main(String[] args) {
		EmployeeDao emp=new EmployeeDaoImpl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee id");
		int id=sc.nextInt();
		
		String add=emp.getAddressOfEmployee(id);

		System.out.println(add);
	}
	


}
