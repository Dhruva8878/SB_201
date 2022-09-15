package ASS_3;

import java.util.List;

public class GetAlltheStudentsByCourseName {
	
	public static void main(String[] args) throws CourseException {
		
		SchoolDAO sc=new SchoolDAOImpl();
		
		List<Student> list=sc.getAlltheStudentsByCourseName("DSA");
		
		for(Student s:list) {
			System.out.println(s);
		}
	}

}
