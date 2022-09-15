package ASS_3;

public class RegisterStudent {
	
	public static void main(String[] args) throws CourseException {
		SchoolDAO sch=new SchoolDAOImpl();
		Student s=new Student();
		s.setName("Ram");
		s.setMobile("8878763115");
		s.setEmail("Ram@gmail.com");
		
		sch.registerStudent(s, 1);
	}

}
