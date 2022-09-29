package com.log.service;

import com.log.exception.LoginException;
import com.log.exception.SingUpException;
import com.log.model.CurrentUserSession;
import com.log.model.SingUp;

public interface CurrentSessionService {
	
	public SingUp getSignUpdetails(String key) throws SingUpException;
	
	public CurrentUserSession getSessionIdByUserId(Integer key);

	public CurrentUserSession getdetailsByuuid(String key) throws LoginException;

}
