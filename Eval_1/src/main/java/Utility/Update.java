package Utility;

import java.util.Scanner;

import com.account.detail.Account;

import DAO.Impl.AccountImpl;
import account.DAO.AccountDao;

public class Update {
	public static void main(String[] args) {
		
   AccountDao acc=new AccountImpl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Existing id");
		int id=sc.nextInt();
		System.out.println("Enter email");
		String email=sc.next();
		System.out.println("Enter address");
		String add=sc.next();
		System.out.println("Enter Balance");
		double bal=sc.nextDouble();
		
		Account ac=new Account(id, email, add, bal);
		
		String val= acc.update(ac);
		
		System.out.println(val);
		
	}

}
