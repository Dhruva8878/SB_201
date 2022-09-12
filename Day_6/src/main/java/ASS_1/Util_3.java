package ASS_1;

import javax.persistence.EntityManager;

public class Util_3 {
	
	  public static void main(String[] args) {
		
	  EntityManager em=Demo.provideManager();
	  
	  Student s=em.find(Student.class, 2);
       
	  if(s!=null) {
		  Collage c= s.getCollage();
		   
		  System.out.println(c.getCollageId());
		  System.out.println(c.getCollageName());
		  System.out.println(c.getCollageAddress());
		  System.out.println("----------------------");
	  }
	  else {
		  System.out.println("Student Doesn't Exist");
	  }
	  
	  }

}
