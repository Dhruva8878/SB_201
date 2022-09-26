package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.AccountException;
import com.masai.Exception.InsufficientFundException;
import com.masai.model.Account;
import com.masai.model.AccountDTO;
import com.masai.service.AccountDAO;

@RestController
public class Accountcontroller {
	
	@Autowired
	public AccountDAO acd;
	
	@PostMapping("/openAcc")
	public ResponseEntity<Account> accOpenHandler(@RequestBody Account acc) throws AccountException{
		
		Account ac= acd.openAccount(acc);
		
		return new ResponseEntity<Account>(ac,HttpStatus.CREATED);
	}

	@DeleteMapping("/closeAcc/{accno}")
	public ResponseEntity<Account> accClosehanlder(@PathVariable("accno") Integer accno) throws AccountException{
		
		Account ac=acd.closeAccount(accno);
	 
		return new ResponseEntity<Account>(ac,HttpStatus.OK);
	}
	
	@PutMapping("/dosAcc/{accno}/{amount}")
	public ResponseEntity<Account> depositHandler(@PathVariable("accno") Integer accno,
			                                       @PathVariable("amount") Integer amount) throws AccountException{
		
		Account ac=acd.depositAmount(accno, amount);
		
		return new ResponseEntity<Account>(ac,HttpStatus.OK);
		
	}
	
	@PutMapping("/wit/{accno}/{amount}")
	public ResponseEntity<Account> WithdrawHandler(@PathVariable("accno") Integer accno,
                                                    @PathVariable("amount") Integer amount) throws AccountException, InsufficientFundException{
		
		Account ac=acd.withdrawAmmount(accno, amount);
	
		return new ResponseEntity<Account>(ac,HttpStatus.OK);
	}
	 
	@PutMapping("/trans")
	public ResponseEntity<String> transferHandler(@RequestBody AccountDTO dto) throws AccountException, InsufficientFundException{
		
		String msg=acd.transferAmount(dto);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	   
	   
}
