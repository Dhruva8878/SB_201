package ass_1;

import java.util.List;

public interface EmployeeRepo {
	
	
	public boolean insertEmployeeDetails(Employee emp);
	public List getAllEmployeeDetails();
	public Employee findEmployee(int empId);
	public String deleteEmployeeDetailsById(int empId);

}
