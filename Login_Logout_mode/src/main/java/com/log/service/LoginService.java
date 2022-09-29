package com.log.service;

import com.log.exception.LoginException;
import com.log.exception.SingUpException;
import com.log.model.LoginData;
import com.log.model.SingUp;

public interface LoginService {
	
	public LoginData loginAccount(LoginData loginData) throws LoginException, SingUpException;
	
	public LoginData LogoutfromAccount(String key) throws LoginException;
	
	

}
