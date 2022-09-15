package ASS_3;

public class RegisterTeacher {

	public static void main(String[] args) {
		
		SchoolDAO sc=new SchoolDAOImpl();
		Teacher tc=new Teacher();
		
		tc.setEmail("T1@gmail.com");
		tc.setNoYearOfExperince(10);
		tc.setTeacherName("T1");

		
		sc.registerTeacher(tc);
	}
}
