package com.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.log.exception.LoginException;
import com.log.exception.SingUpException;
import com.log.model.LoginData;
import com.log.repo.CurrentUserDAO;
import com.log.repo.LoginDataDAO;
import com.log.service.LoginService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class loginController {
	
	@Autowired
	public LoginService loginService;
	
	@Autowired
	public CurrentUserDAO currentUserDAO;
	
	@PostMapping("/login")
	public ResponseEntity<LoginData> saveLoginData(@RequestBody LoginData loginData) throws LoginException, SingUpException{
		
		LoginData log= loginService.loginAccount(loginData);
		
		return new ResponseEntity<LoginData>(log,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/logout/{key}")
	public ResponseEntity<LoginData> removeLoginData(@PathVariable("key") String key) throws LoginException{
		
		LoginData log= loginService.LogoutfromAccount(key);
		
		return new  ResponseEntity<LoginData>(log,HttpStatus.OK);
	}

}
