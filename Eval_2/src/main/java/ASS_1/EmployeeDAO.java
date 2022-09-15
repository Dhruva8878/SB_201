package ASS_1;

import java.util.List;

public interface EmployeeDAO {

	public void addDepartment(Department dept);
	
	public void addEmployee(Employee emp);
	
	public void registerEmployeeTODepartment(int empId, int deptId)throws
	EmployeeException, DepartmentException;
	
	public List<Employee> getAllEmployeeWithDeptName(String deptName)throws
	EmployeeException;
	
	public  Department getDepartmentDetailsByEmployeeId(int empId)throws
	DepartmentException;
	
	
	
	
}
