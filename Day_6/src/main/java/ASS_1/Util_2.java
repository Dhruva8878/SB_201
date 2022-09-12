package ASS_1;

import java.util.List;

import javax.persistence.EntityManager;

import ASS_2.Demo;

public class Util_2 {
	
	public static void main(String[] args) {
		
		EntityManager em=Demo.provideManager();
		
		Collage cl=em.find(Collage.class, 1);
		List<Student> list=cl.getList();

		list.forEach(s ->{
			System.out.println(s.getStudentRoll());
			System.out.println(s.getStudentName());
			System.out.println(s.getMobileNumber());
			System.out.println(s.getEmail());
		});
	}

}
