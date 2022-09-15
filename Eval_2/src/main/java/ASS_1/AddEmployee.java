package ASS_1;

public class AddEmployee {
	
	public static void main(String[] args) {
		EmployeeDAO emp=new EmployeeDaoImpl();
		Department dep=new Department();
		
		
		
		dep.setDeptName("HR");
		dep.setLocation("Indore");	
		emp.addDepartment(dep);
	}

}
