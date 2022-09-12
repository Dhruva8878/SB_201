package ASS_1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Demo {
	
	static EntityManagerFactory emf;
	
	static {
		emf=Persistence.createEntityManagerFactory("CustomerUnit");
	}
	public static EntityManager provideManager() {
		
		return emf.createEntityManager();
		
	}

}
