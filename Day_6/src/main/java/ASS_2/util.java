package ASS_2;

import javax.persistence.EntityManager;

public class util {
	
	public static void main(String[] args) {
		
		EntityManager em=Demo.provideManager();
		
		Customer cus=new Customer();
		cus.setEmail("kgf@gmail.com");
		cus.setMobileNumber("9078903116");
		cus.setName("Vikas");
		
		cus.getAddresses().add(new Address("Kerala","Vishakhapatnam","458551"));
		cus.getAddresses().add(new Address("Jammu", "Kashmir","997612"));
		
		
		em.getTransaction().begin();
		
		em.persist(cus);
		
		em.getTransaction().commit();
		
		em.close();
		
	}

}
