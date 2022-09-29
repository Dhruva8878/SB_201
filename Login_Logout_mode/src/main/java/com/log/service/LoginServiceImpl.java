package com.log.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.exception.LoginException;
import com.log.exception.SingUpException;
import com.log.model.CurrentUserSession;
import com.log.model.GetUuid;
import com.log.model.LoginData;
import com.log.model.SingUp;
import com.log.repo.CurrentUserDAO;
import com.log.repo.LoginDataDAO;
import com.log.repo.SignUpDataDAO;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	public LoginDataDAO loginDataDAO;
	
	@Autowired
	public SignUpDataDAO signUpDataDAO;
	
	@Autowired
	public CurrentUserDAO currentUserDAO;
	
	@Autowired
	public CurrentSessionService currentSessionService;
	

	@Override
	public LoginData loginAccount(LoginData loginData) throws LoginException, SingUpException {
		
		Optional<SingUp> d1=signUpDataDAO.findById(loginData.getUserId());
		
		if(d1.isPresent()) {
			
		CurrentUserSession cur=currentSessionService.getSessionIdByUserId(loginData.getUserId());
		
		    if(cur!=null) {
		    	throw new LoginException("User Has Already Login");
		      }
		    else {
			   CurrentUserSession c= new CurrentUserSession(loginData.getUserId(), LocalDateTime.now(),
					  GetUuid.getRandomNumberString());
			   currentUserDAO.save(c);
			
			   if(d1.get().getPassword().equals(loginData.getPassword()) && d1.get().getName().equals(loginData.getName())) {
				   return loginDataDAO.save(loginData);
			   }
			   else {
				   throw new LoginException("user has to give right credentials");
			   }
		       
		          }	
		  }
		else {
			throw new SingUpException("Please you have to signUp first");
		}
		
	}

	@Override
	public LoginData LogoutfromAccount(String key) throws LoginException {
	
		CurrentUserSession cur=currentSessionService.getdetailsByuuid(key);
		
		if(cur==null) {
			throw new LoginException("User Has already Logged Out");
		}
		else {
		 
			Integer id=cur.getUserId();
			LoginData log= loginDataDAO.findById(id).get();
			
			loginDataDAO.delete(log);
			
			currentUserDAO.delete(cur);
			
			return log;
		}
	
	}

}
