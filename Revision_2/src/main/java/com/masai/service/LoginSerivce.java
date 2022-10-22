package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.exception.SignUpException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Login;

public interface LoginSerivce {

    public CurrentUserSession loginAccount(Login loginData) throws SignUpException, LoginException;
	
	public CurrentUserSession LogoutfromAccount(String key) throws LoginException, SignUpException;
	
}
