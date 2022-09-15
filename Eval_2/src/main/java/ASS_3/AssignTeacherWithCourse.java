package ASS_3;

public class AssignTeacherWithCourse {
	
	public static void main(String[] args) throws TeacherException, CourseException {
		SchoolDAO sc=new SchoolDAOImpl();
		
		sc.assignTeacherWithCourse(3, 1);
	}

}
