package Utility;

import java.util.Scanner;

import com.account.detail.Account;

import DAO.Impl.AccountImpl;
import account.DAO.AccountDao;

public class FindById {
	
	public static void main(String[] args) {
		
		AccountDao acc=new AccountImpl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id");
		
		int id=sc.nextInt();
		
		
		Account ac=acc.findById(id);
		if(ac!=null) {
			System.out.println(ac);
		}
		else {
			System.out.println("Account Not found");
		}
		
		
	}

}
