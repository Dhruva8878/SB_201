package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.SignUpException;
import com.masai.model.SignUp;
import com.masai.repo.SignUpDAO;

public class SignUpServiceImpl implements SignUpService {
 
	@Autowired
	public SignUpDAO signUpDAO;
	
	@Override
	public SignUp registerUser(SignUp signUp) throws SignUpException {
		
		SignUp sign= signUpDAO.save(signUp);
		
		if(sign!=null) {
			return sign;
		}
		else {
			throw new SignUpException("NO details found");
		}
	}

	@Override
	public SignUp updateUser(SignUp signUp) throws SignUpException {
		
		Optional<SignUp> data=signUpDAO.findById(signUp.getUserId());
		
		if(data.isPresent()) {
			return signUpDAO.save(signUp);
		}
		else {
			throw new SignUpException("No details found");
		}
		
	}

	@Override
	public SignUp getDetailsById(Integer id) throws SignUpException {
		
		Optional<SignUp> data=signUpDAO.findById(id);
		
		if(data.isPresent()) {
			return data.get();
		}
		else {
			throw new SignUpException("No user registered with this id");
		}
	}
	
	

}
