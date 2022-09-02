package com.masai;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo {

	public static void main(String[] args) {
		
		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("studentUnit");
		 
		    EntityManager em=emf.createEntityManager();
		    
		    
		    
		    
		    
		    
		    
		   
		    
		    
		    
		    
		    
		    
		    
//		    Scanner sc=new Scanner(System.in);
//		    System.out.println("Enter roll to give grace marks");
//		    
//		    int roll=sc.nextInt();
//		    
//		    Student st=em.find(Student.class, roll);
//		    
//		    if(st==null) {
//		    	System.out.println("Student not found");
//		    }
//		    else {
//		    	System.out.println("Enter grace marks");
//		    	int mark=sc.nextInt();
//		    	
//		    	em.getTransaction().begin();
//		    	st.setMarks(st.getMarks()+mark);
//		    	em.getTransaction().commit();
//		    	
//		    }
		    
		    
		    
		    
		    
		    
//		    Student student=new Student(20,"Dhruv",500);
		    
		    
		    
	
//		    Scanner sc=new Scanner(System.in);
//		    System.out.println("Enter roll no.");
//		    
//		    int roll=sc.nextInt();
//		    
//		    Student st=em.find(Student.class, roll);
//		    
//		    if(st!=null) {
//		    	em.getTransaction().begin();
//		    	em.remove(st);
//		    	em.getTransaction().commit();
//		    }
//		    else {
//		    	System.out.println("Student not found");
//		    }
//		    
		    
		    
		    
		    
		   
//		    em.getTransaction().begin();
//		    em.persist(student);
//		    em.getTransaction().commit();

		    
		    
		    
            
//		    Student s=em.find(Student.class, 10);
//		    
//		    if(s!=null) {
//		    	  System.out.println(s);
//		    }
//		    else {
//		    	System.out.println("student not found");
//		    }
		    
		    em.close();
//		  
		  
	}

}
