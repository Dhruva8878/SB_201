package com.masai.service;

import com.masai.exception.SignUpException;
import com.masai.model.SignUp;

public interface SignUpService {
    
	public SignUp registerUser(SignUp signUp) throws SignUpException;
	
	public SignUp updateUser(SignUp signUp) throws SignUpException;
	
	public SignUp getDetailsById(Integer id) throws SignUpException;
	
}
