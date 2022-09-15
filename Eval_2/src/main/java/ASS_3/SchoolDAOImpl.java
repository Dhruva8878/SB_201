package ASS_3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import EntityUtil.Util;

public class SchoolDAOImpl implements SchoolDAO{

	@Override
	public void addCourse(Course course) {
	
		EntityManager em=Util.provideManager();
		
		em.getTransaction().begin();
		em.persist(course);
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Done ...");
		
	}

	@Override
	public void registerStudent(Student student, int courseId) throws CourseException {
	   
		EntityManager em=Util.provideManager();
		
		Course cs= em.find(Course.class, courseId);
		
		if(cs!=null) {
			cs.getList().add(student);
			
			em.getTransaction().begin();
			
			em.merge(cs);
			student.getCourses().add(cs);
			
			em.getTransaction().commit();
			
		}
		else {
			throw new CourseException("Course not found");
		}
		
		em.close();
	}

	@Override
	public void registerTeacher(Teacher teacher) {
		
		EntityManager em=Util.provideManager();
		
		em.getTransaction().begin();
		
		em.persist(teacher);

		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public void assignTeacherWithCourse(int teacherId, int courseId) throws TeacherException, CourseException {
		
		EntityManager em=Util.provideManager();
		
		Teacher tc= em.find(Teacher.class, teacherId);
		Course cs=em.find(Course.class, courseId);
		
		if(tc==null) {
			throw new TeacherException("Teacher Not Exist");
		}
		if(cs==null) {
			throw new CourseException("Course Not found");
		}
		
		em.getTransaction().begin();
		
		tc.getCourses().add(cs);
		
		em.getTransaction().commit();
		
		em.close();
		
	}

	@Override
	public List<Student> getAlltheStudentsByCourseName(String courseName) throws CourseException {
		List<Student> students=null;
		
		EntityManager em=Util.provideManager();
		
		String jpql="from Student where  student_course.sid= student.roll courseName=:c";
		Query q=em.createQuery(jpql);
		q.setParameter("c", courseName);
		
		students=q.getResultList();
		if(students.size()==0) {
			throw new CourseException("Course Not Found");
		}
		
		return students;
	}
 
	
}
