package com.log.service;

import com.log.exception.LoginException;
import com.log.exception.SingUpException;
import com.log.model.SingUp;

public interface SignUpService {
	
	public SingUp getAllSigndataById(Integer userId) throws SingUpException;
	
	public SingUp addSignUpData(SingUp singUp) throws SingUpException;
	
	public SingUp updateSingUp(SingUp singUp) throws SingUpException;

}
