package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.LoginException;
import com.masai.exception.SignUpException;
import com.masai.model.CurrentUserSession;
import com.masai.model.GetUuid;
import com.masai.model.Login;
import com.masai.model.SignUp;
import com.masai.repo.CurrentSessionDAO;
import com.masai.repo.LoginDAO;
import com.masai.repo.SignUpDAO;

public  class LoginServiceImpl implements  LoginSerivce{

	@Autowired
	public SignUpDAO signUpDAO;
	
	@Autowired
	public CurrentSessionDAO currentSessionDAO;
	
	@Override
	public CurrentUserSession loginAccount(Login loginData) throws SignUpException, LoginException {
		
		Optional<SignUp> Sdata=signUpDAO.findById(loginData.getUserId());
		
		if(Sdata.isPresent()) {
			
			Optional<CurrentUserSession> cur=currentSessionDAO.findByuserId(loginData.getUserId());
			
			if(cur.isPresent()) {
				throw new LoginException("User has Already Logged in");
			}
			else {
				
				CurrentUserSession newUser=new CurrentUserSession(loginData.getUserId(), LocalDateTime.now(),
				     GetUuid.getRandomNumberString());
				
				return currentSessionDAO.save(newUser); 
				
			}
          		
		}
		else {
			throw new SignUpException("Please SignUp");
		}
	}

	@Override
	public CurrentUserSession LogoutfromAccount(String key) throws LoginException, SignUpException {
		
		Optional<CurrentUserSession> cur=currentSessionDAO.findByuuid(key);
		
		
		if(cur.isPresent()) {
			currentSessionDAO.delete(cur.get());
			
			return cur.get();
		}
		else {
			throw new SignUpException("No user logged in the Account");
		}

	}
		
}
