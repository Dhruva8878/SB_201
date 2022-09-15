package ASS_1;

import javax.persistence.EntityManager;

public class Util {
	
	public static void main(String[] args) {
		
		EntityManager em=Demo.provideManager();
		
		Employee emp=new Employee();
		emp.setName("Ram");
		emp.setSalary(25000);
		emp.setHomeAddress(new Address("MP","Indore","452001"));
		emp.setOfficeAddress(new Address("Up","Bihar","345123"));
		
		
		em.getTransaction().begin();
		
		em.persist(emp);
		
		em.getTransaction().commit();
		
		em.close();
	}

}
