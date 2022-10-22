package com.masai.service;

import java.util.Optional;

import com.masai.exception.LoginException;
import com.masai.exception.SignUpException;
import com.masai.model.CurrentUserSession;
import com.masai.model.SignUp;

public interface CurrentUserService {

   public SignUp getSignUpdetails(String key) throws LoginException, SignUpException ;
	
	public Optional<CurrentUserSession> getSessionIdByUserId(Integer key) throws LoginException;

	public Optional<CurrentUserSession> getdetailsByuuid(String key) throws LoginException;

	
}
