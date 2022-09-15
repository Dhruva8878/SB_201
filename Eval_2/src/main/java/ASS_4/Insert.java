package ASS_4;

import javax.persistence.EntityManager;

import EntityUtil.Util;

public class Insert {

	public static void main(String[] args) {
		
		SalariedEmployee se=new SalariedEmployee();
		
		se.setEmpName("Ram");
		se.setEmail("Ram@gmail.com");
		se.setSalary(25000);
		
		
     SalariedEmployee s2=new SalariedEmployee();
		
		s2.setEmpName("Ramesh");
		s2.setEmail("Ramesh@gmail.com");
		s2.setSalary(26989);
		
SalariedEmployee s3=new SalariedEmployee();
		
		s3.setEmpName("Rakesh");
		s3.setEmail("Rakesh@gmail.com");
		s3.setSalary(25777);
		
SalariedEmployee s4=new SalariedEmployee();
		
		s4.setEmpName("Raj");
		s4.setEmail("Raj@gmail.com");
		s4.setSalary(35000);
				
	
		ConractualEmployee c1=new ConractualEmployee(20, 500, "8878763116");
		c1.setEmpName("Prakash");
		
		ConractualEmployee c2=new ConractualEmployee(25, 700, "8878763116");
		c2.setEmpName("Prashant");
		
		ConractualEmployee c3=new ConractualEmployee(10, 1000, "888763116");
		c3.setEmpName("Dhruv");
		
		ConractualEmployee c4=new ConractualEmployee(20, 500, "899753116");
		c1.setEmpName("Shyam");
		
		EntityManager em=Util.provideManager();
		
		
		em.getTransaction().begin();
		
		em.persist(se);
		em.persist(s2);
        em.persist(s3);
        em.persist(s4);
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
		em.getTransaction().commit();
		
		em.close();
	}
}
