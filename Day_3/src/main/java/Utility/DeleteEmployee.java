package Utility;

import java.util.Scanner;

import com.DAO.EmployeeDao;
import com.daoImpl.EmployeeDaoImpl;

public class DeleteEmployee {

	
	public static void main(String[] args) {
		
		EmployeeDao emp=new EmployeeDaoImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee id");
		int id=sc.nextInt();
		
		boolean ans=emp.deleteEmployee(id);
		
		if(ans) {
			System.out.println("Deleted Successfully");
		}
		else {
			System.out.println("Not deleted");
		}
		
	}
}
