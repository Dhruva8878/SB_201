package ASS_1;

import javax.persistence.EntityManager;

import ASS_2.Demo;

public class Util_1 {
	
	public static void main(String[] args) {
		
		EntityManager em=Demo.provideManager();
		
		Collage clg=new Collage();
		
		clg.setCollageName("DAVV");
		clg.setCollageAddress("Indore");
		
		Student s1=new Student();
		s1.setStudentName("Ram");
		s1.setMobileNumber("887876311");
		s1.setEmail("Ram@gmail.com");
		s1.setCollage(clg);
		
		Student s2=new Student();
		s2.setStudentName("Ramesh");
		s2.setMobileNumber("887556311");
		s2.setEmail("Ramesh@gmail.com");
		s2.setCollage(clg);
		
		Student s3=new Student();
		s3.setStudentName("Rakesh");
		s3.setMobileNumber("885676311");
		s3.setEmail("Rakesh@gmail.com");
		s3.setCollage(clg);
		
		clg.getList().add(s1);
		clg.getList().add(s2);
		clg.getList().add(s3);
		
		
		em.getTransaction().begin();
		
		em.persist(clg);
		
		em.getTransaction().commit();
		
		
		em.close();
		
	}

}
