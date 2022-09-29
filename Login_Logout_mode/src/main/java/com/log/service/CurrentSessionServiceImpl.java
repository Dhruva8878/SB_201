package com.log.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.exception.LoginException;
import com.log.exception.SingUpException;
import com.log.model.CurrentUserSession;
import com.log.model.SingUp;
import com.log.repo.CurrentUserDAO;
import com.log.repo.SignUpDataDAO;

@Service
public class CurrentSessionServiceImpl implements CurrentSessionService{

	@Autowired
	public CurrentUserDAO currentUserDAO;
	
	@Autowired
	public SignUpDataDAO signUpDataDAO;

	@Override
	public CurrentUserSession getdetailsByuuid(String key) throws LoginException {
		
	 CurrentUserSession cur= currentUserDAO.findByuuid(key);
	  
	 if(cur==null) {
		 throw new LoginException("To get UUID user has to login first");
	 }
	 else {
		 return cur; 
	 }
		
		
	}

	@Override
	public SingUp getSignUpdetails(String key) throws SingUpException {
		CurrentUserSession cur= currentUserDAO.findByuuid(key);
		
		if(cur==null) {
			throw new SingUpException("User has To SignUp first"); 
		}
		else {
			return signUpDataDAO.findById(cur.getUserId()).get();
		}
	}

	@Override
	public CurrentUserSession getSessionIdByUserId(Integer key) {
		
		CurrentUserSession cur= currentUserDAO.findByuserId(key);
		
		return cur;
	}


}
