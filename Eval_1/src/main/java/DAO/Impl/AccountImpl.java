package DAO.Impl;

import javax.persistence.EntityManager;

import com.account.detail.Account;
import com.account.detail.Demo;

import account.DAO.AccountDao;

public class AccountImpl implements AccountDao{

	@Override
	public Account findById(int id) {
		
		Account ac=null;
		
		EntityManager em=Demo.provideConnection();
		
		ac=em.find(Account.class, id);
		
		em.close();
		
		return ac;
	}

	@Override
	public String save(Account account) {
		String res="Inserted Successfully...";
		
		EntityManager em=Demo.provideConnection();
		
		em.getTransaction().begin();
		
		em.persist(account);
		
		em.getTransaction().commit();
		
		
		em.close();
		return res;
	}

	@Override
	public String update(Account account) {
		String res="Not Updated...";
		
		EntityManager em= Demo.provideConnection();
		
		Account ac=em.find(Account.class, account.getId());
		
		if(ac!=null) {
			em.getTransaction().begin();
			ac.setAddress(account.getAddress());
			ac.setBalance(account.getBalance());
			ac.setEmail(account.getEmail());
			
			em.getTransaction().commit();
			
			res="Upadated Successfully";
			
		}
		else {
			res="account Not Found..";
		}
		
		
		em.close();
		return res;
	}

	@Override
	public String remove(int id) {
		String res="Not Removed..";
		
		EntityManager em=Demo.provideConnection();
		
		Account ac=em.find(Account.class, id);
		
		if(ac!=null) {
			em.getTransaction().begin();
			
			em.remove(ac);
			
			em.getTransaction().commit();
			
			res="Removed Successfully...";
		}
		else {
			res="Account Not found...";
		}
		
		em.close();
		return res;
	}

	@Override
	public String withdraw(double amount, int accountId) {
	    String res="Not withdrawed...";
	    
	    EntityManager em=Demo.provideConnection();
	    
	    Account ac=em.find(Account.class, accountId);
	    
	    if(ac!=null) {
	    	
	    	em.getTransaction().begin();
	    	
	    	ac.setBalance(ac.getBalance()-amount);
	    	
	    	em.getTransaction().commit();
	    	
	    	res="Withdrwal Successfull";
	    	
	    }
	    else {
	    	res="Account Doesn't Exist...";
	    }
		
	    em.close();
		return res;
	}

	@Override
	public String deposit(double amount, int accountId) {
		
		String  res="Not Updated";
		
		EntityManager em= Demo.provideConnection();
		
		Account ac=em.find(Account.class,accountId);
		
		if(ac!=null) {
			
			em.getTransaction().begin();
			
			ac.setBalance(ac.getBalance()+amount);
			
			em.getTransaction().commit();
			
			res="Updated Successfully...";
		}
		else {
			res="Account Doesn't Exist..";
		}
		
		em.close();
		return res;
	}

}
