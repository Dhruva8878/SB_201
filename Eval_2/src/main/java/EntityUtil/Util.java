package EntityUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Util {
	
	static EntityManagerFactory emf;

	static {
		emf=Persistence.createEntityManagerFactory("studentUnit");
	}
	public static EntityManager provideManager() {
		
		return emf.createEntityManager();
	}
}
