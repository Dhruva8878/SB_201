package com.masai.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {
	
	public static EntityManagerFactory emf;

	static {
		 emf=Persistence.createEntityManagerFactory("BookUnit");
	}
	
	public static EntityManager provideManager() {
		
		return emf.createEntityManager();
	}
}
