package com.log.service;

import java.util.Optional;

import com.log.exception.LoginException;
import com.log.exception.SingUpException;
import com.log.model.CurrentUserSession;
import com.log.model.SingUp;

public interface CurrentSessionService {
	
	public SingUp getSignUpdetails(String key) throws SingUpException;
	
	public Optional<CurrentUserSession> getSessionIdByUserId(Integer key);

	public Optional<CurrentUserSession> getdetailsByuuid(String key) throws LoginException;

}
