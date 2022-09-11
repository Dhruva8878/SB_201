package ASS_1;

import java.util.Scanner;

import javax.persistence.EntityManager;

public class Utility {
	
	
	public static void main(String[] args) {
		EntityManager em=Demo.provideManager();
		
		int i=0;
		
		while(i<5) {
			Employee emp=new Employee();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Gender");
			String gen=sc.next();
			System.out.println("Enter Name");
			String name=sc.next();
			System.out.println("Enter salary");
			int sal=sc.nextInt();
			
			emp.setGender(gen);
			emp.setName(name);
			emp.setSalary(sal);
			
			emp.getEmpAddress().add(new Address("MP", "Indore","452001","Office"));
			emp.getEmpAddress().add(new Address("UP","Bihar", "567891","Home"));
			
			
			em.getTransaction().begin();
			
			em.persist(emp);
			
			em.getTransaction().commit();
			
			i++;
		}
		
		
		em.close();
		
		
	}

}
