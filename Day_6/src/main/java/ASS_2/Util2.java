package ASS_2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Util2 {
	
	public static void main(String[] args) {
		
		EntityManager em=Demo.provideManager();
		
		String jpql="from Customer";
		Query q=em.createQuery(jpql);
		
		List<Customer> cus= q.getResultList();
		
		for(Customer c:cus) {
			System.out.println("Id is : "+c.getCid());
			System.out.println("Name is : "+c.getName());
			System.out.println("Email is : "+c.getEmail());
			System.out.println("Mobile No is : "+c.getMobileNumber());
			
			System.out.println("Addresses Are :");
			List<Address> add=c.getAddresses();
			
			for(Address ad:add) {
				System.out.println(ad);
			}
			
		}
		
	em.close();	
		
	}

}
