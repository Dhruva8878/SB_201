package com.masai.service;

import com.masai.Exception.AccountException;
import com.masai.Exception.InsufficientFundException;
import com.masai.model.Account;
import com.masai.model.AccountDTO;

public interface AccountDAO {
	
	public Account openAccount(Account acc)throws AccountException;
	
	public Account closeAccount(Integer accno)throws AccountException;
	
	public Account depositAmount(Integer accno, Integer amount)throws AccountException;

	public Account withdrawAmmount(int accno, Integer amount)throws
	AccountException, InsufficientFundException;
	
	public String transferAmount(AccountDTO dto)throws AccountException,
	InsufficientFundException;
	
}
