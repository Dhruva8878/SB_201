package ass_1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {
	
	static EntityManagerFactory emf;
	
	static {
		emf=Persistence.createEntityManagerFactory("employeeUnit");
	}
     
	public static EntityManager provideManager() {
		return emf.createEntityManager();
	}
}
