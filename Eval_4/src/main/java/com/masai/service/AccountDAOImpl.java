package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.AccountException;
import com.masai.Exception.InsufficientFundException;
import com.masai.model.Account;
import com.masai.model.AccountDTO;
import com.masai.repo.AccountRepo;

@Service
public class AccountDAOImpl implements AccountDAO {
 
	@Autowired
	public AccountRepo ser;
	
	@Override
	public Account openAccount(Account acc) throws AccountException {
		
		Account ac=ser.save(acc);
		
		if(ac!=null) {
			return ac;
		}
		else {
			throw new AccountException("Wrong Account Credentials");
		}
	}

	@Override
	public Account closeAccount(Integer accno) throws AccountException {
		
		Optional<Account> ac=ser.findById(accno);
		
		if(ac.isPresent()) {
			ser.delete(ac.get());
			return ac.get();
		}
		else {
			throw new AccountException("Account Not found By this AccNo :"+ accno);
		}
	}

	@Override
	public Account depositAmount(Integer accno, Integer amount) throws AccountException {
		
		Optional<Account> acc= ser.findById(accno);
		
		if(acc.isPresent()) {
			
			Account ac=acc.get();
			
			ac.setBalance(ac.getBalance()+amount);
			
			 return ser.save(ac);
		}
		else {
			throw new AccountException("Wrong Credentials");
		}
		
	}

	@Override
	public Account withdrawAmmount(int accno, Integer amount) throws AccountException, InsufficientFundException {
        
		Optional<Account> acc= ser.findById(accno);
		
		if(acc.isPresent()) {
			
			Account ac=acc.get();
			
			if(ac.getBalance()>amount) {
				ac.setBalance(ac.getBalance()-amount);
				
				 return ser.save(ac);
			}
			else {
				throw new InsufficientFundException("Not Suffiesient Balance");
			}
			
		}
		else {
			throw new AccountException("Wrong Credentials");
		}
	}

	@Override
	public String transferAmount(AccountDTO dto) throws AccountException, InsufficientFundException {
		
		Optional<Account> ac1=ser.findById(dto.getSrcAccno());
		
		Optional<Account> ac2=ser.findById(dto.getDesAccno());
		
		if(ac1.isPresent() && ac2.isPresent()) {
			
         Account r1=ac1.get();
         Account r2=ac2.get();
         
         if(r1.getBalance()>dto.getAmount()) {
        	 
        	 r1.setBalance(r1.getBalance()-dto.getAmount());
        	 r2.setBalance(r2.getBalance()+dto.getAmount());
        	 
        	 ser.save(r1);
        	 ser.save(r2);
        	 
        	 return "Transfer Successfull";
         }
         else {
        	 throw new InsufficientFundException("Insufficient Fund in the Account");
         }	
	}
		else {
			throw new AccountException("Wrong credentials");
		}
	}
	
	

}
