package com.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.log.exception.SingUpException;
import com.log.model.SingUp;
import com.log.service.SignUpService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class SignUpController {
	
	@Autowired
	public SignUpService signUpService;
	
	@PostMapping("/signup")
	public ResponseEntity<SingUp> addSingUpdataHandler(@RequestBody SingUp singUp) throws SingUpException{
		
		SingUp sip= signUpService.addSignUpData(singUp);
		
		return new ResponseEntity<SingUp>(sip,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updateSign")
	public ResponseEntity<SingUp> updateSignupHandler(@RequestBody SingUp singUp) throws SingUpException{
		
		SingUp sip=signUpService.updateSingUp(singUp);
		
		return new ResponseEntity<SingUp>(sip,HttpStatus.OK);
	}
	
	public ResponseEntity<SingUp> getUserDataByUserId(Integer id) throws SingUpException{
		
		SingUp sip=signUpService.getAllSigndataById(id);
		
		return new ResponseEntity<SingUp>(sip,HttpStatus.OK);
		
	}
	

}
