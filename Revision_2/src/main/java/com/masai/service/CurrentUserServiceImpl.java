package com.masai.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.LoginException;
import com.masai.exception.SignUpException;
import com.masai.model.CurrentUserSession;
import com.masai.model.SignUp;
import com.masai.repo.CurrentSessionDAO;
import com.masai.repo.SignUpDAO;

public class CurrentUserServiceImpl implements CurrentUserService{

	@Autowired
	public SignUpDAO signUpDAO;
	
	@Autowired
	public CurrentSessionDAO currentSessionDAO;
	
	 
	@Override
	public SignUp getSignUpdetails(String key) throws LoginException, SignUpException {
		
		Optional<CurrentUserSession> cur=currentSessionDAO.findByuuid(key);
		
		if(cur.isPresent()) {
			Optional<SignUp> Sdata=signUpDAO.findById(cur.get().getUserId());
			
			if(Sdata.isPresent()) {
				return Sdata.get();
			}
			else {
				throw new SignUpException("No SignUp details found");
			}
		}
		else {
			throw new LoginException("No user found by uuid");
		}
		
	}

	@Override
	public Optional<CurrentUserSession> getSessionIdByUserId(Integer key) throws LoginException {
		
		Optional<CurrentUserSession> cur=currentSessionDAO.findByuserId(key);
		
		if(cur.isPresent()) {
			return cur;
		}
		else {
			throw new LoginException("No data found");
		}
	}

	@Override
	public Optional<CurrentUserSession> getdetailsByuuid(String key) throws LoginException {
		
		Optional<CurrentUserSession> cur=currentSessionDAO.findByuuid(key);
		
		if(cur.isPresent()) {
			return cur;
		}
		else {
			throw new LoginException("No data found");
		}
	}
	
	

}
