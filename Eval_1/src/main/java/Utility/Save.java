package Utility;

import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;

import com.account.detail.Account;

import DAO.Impl.AccountImpl;
import account.DAO.AccountDao;

public class Save {

	public static void main(String[] args) {
		
		AccountDao acc=new AccountImpl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id");
		int id=sc.nextInt();
		System.out.println("Enter email");
		String email=sc.next();
		System.out.println("Enter address");
		String add=sc.next();
		System.out.println("Enter Balance");
		double bal=sc.nextDouble();
		
		Account ac=new Account(id, email, add, bal);
		
	    String val=acc.save(ac);
         
	    System.out.println(val);
	}
}
