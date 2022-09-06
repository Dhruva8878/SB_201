package com.account.detail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo {
	
	public static EntityManager provideConnection() {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("account");
		
	   EntityManager em=emf.createEntityManager();
	
		
	   return em;
	}

}
