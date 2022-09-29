package com.log.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.exception.LoginException;
import com.log.exception.SingUpException;
import com.log.model.SingUp;
import com.log.repo.SignUpDataDAO;

@Service
public class SignUpServiceImpl implements SignUpService{
	
	@Autowired
	public  SignUpDataDAO signUpDataDAO;

	@Override
	public SingUp getAllSigndataById(Integer userId) throws SingUpException {
	
		Optional<SingUp> singUp = signUpDataDAO.findById(userId);
		
		if(singUp.isPresent()) {
			
			return singUp.get();
			
		}
		else {
			throw new SingUpException("No details found with that id :" +userId);
		}
		 
	}

	@Override
	public SingUp addSignUpData(SingUp singUp) throws SingUpException {
		
		if(singUp!=null) {
			
			SingUp siUp=signUpDataDAO.save(singUp);
			
			return siUp;
		}
		else {
		    
			throw new SingUpException("Error Credentials");	
		}
	}

	@Override
	public SingUp updateSingUp(SingUp singUp) throws SingUpException {
		
		Optional<SingUp> data=signUpDataDAO.findById(singUp.getUserId());
		
		if(data.isPresent()) {
			
			return signUpDataDAO.save(data.get());
			
		}
		else {
			throw new SingUpException("No User found By the details");
		}
	}

}
