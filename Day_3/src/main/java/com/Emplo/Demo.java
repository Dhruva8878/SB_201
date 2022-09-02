package com.Emplo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo {
	
	public static EntityManager provideManager() {
		
		 EntityManagerFactory  emf=Persistence.createEntityManagerFactory("EmployeeUnit");
		  
		 EntityManager em=emf.createEntityManager();
		
		return em;
		
	}

}
