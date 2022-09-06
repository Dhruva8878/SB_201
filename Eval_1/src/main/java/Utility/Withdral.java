package Utility;

import java.util.Scanner;

import DAO.Impl.AccountImpl;
import account.DAO.AccountDao;

public class Withdral {

	
	public static void main(String[] args) {
		
     AccountDao acc=new AccountImpl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id");
		int id=sc.nextInt();
		
		System.out.println("Enter amount");
		double ans=sc.nextDouble();
		
		String val= acc.withdraw(ans, id);
		
		System.out.println(val);
		
		
	}
}
