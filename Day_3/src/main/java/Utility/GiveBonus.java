package Utility;

import java.util.Scanner;

import com.DAO.EmployeeDao;
import com.daoImpl.EmployeeDaoImpl;

public class GiveBonus {
	
	public static void main(String[] args) {
		
		EmployeeDao emp=new EmployeeDaoImpl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee Id");
		int id=sc.nextInt();
		System.out.println("Enter Bonus amount");
		int bonus=sc.nextInt();
		
		String ans=emp.giveBonusToEmployee(id, bonus);
		
		System.out.println(ans);
		
	}

}
