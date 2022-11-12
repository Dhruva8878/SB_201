package com.ecom.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.model.Admin;
import com.ecom.repo.AdminDao;

@Service
public class AdminServiceImpl implements AdminServices {

	@Autowired
	private AdminDao dao;
	
	
	@Override
	public Admin Register(Admin admin) {
		// TODO Auto-generated method stub
		Admin ad=dao.save(admin);
		
		return ad;
	}


//	@Override
//	public String Login(String userId, String Password) {
//		// TODO Auto-generated method stub
//		
//		 Optional user= dao.findByUserId(userId);
//		 if(user.isPresent()) {
//			 return "ok";
//		 }
//		
//		return null;
//	}

}
