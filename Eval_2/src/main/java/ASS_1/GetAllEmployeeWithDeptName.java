package ASS_1;

import java.util.List;

public class GetAllEmployeeWithDeptName {

	public static void main(String[] args) throws EmployeeException {
		
		EmployeeDAO emp=new EmployeeDaoImpl();
		
		List<Employee> li= emp.getAllEmployeeWithDeptName("HR");
		
		for(Employee e: li){
			System.out.println(e);
		}
	}
}
