package Utility;

import java.util.Scanner;

import DAO.Impl.AccountImpl;
import account.DAO.AccountDao;

public class AccRemove {
	
	
	public static void main(String[] args) {
		
      AccountDao acc=new AccountImpl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id");
		int id=sc.nextInt();
		
		String val= acc.remove(id);
		
		System.out.println(val);
	}

}
