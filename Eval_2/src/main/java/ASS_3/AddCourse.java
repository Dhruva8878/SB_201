package ASS_3;

import ASS_1.EmployeeDAO;
import ASS_1.EmployeeDaoImpl;

public class AddCourse {
	
	public static void main(String[] args) {
		SchoolDAO sch=new SchoolDAOImpl();
		Course cs=new Course();
		
		cs.setCourseName("DSA");
		cs.setDuration("8 month");
		cs.setFee(25000);
		
		
		sch.addCourse(cs);
				
	}

}
