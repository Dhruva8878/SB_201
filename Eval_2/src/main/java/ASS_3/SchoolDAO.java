package ASS_3;

import java.util.List;

public interface SchoolDAO {
	
	public void addCourse(Course course);
   
	 public void registerStudent(Student student,int courseId)throws CourseException;
    
	 public void registerTeacher(Teacher teacher);
	 
	 public void assignTeacherWithCourse(int teacherId, int courseId) throws
	 TeacherException, CourseException;
	 
	 public List<Student> getAlltheStudentsByCourseName(String courseName)throws
	 CourseException;
}
