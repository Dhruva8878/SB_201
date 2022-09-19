package ass_1;

import java.util.List;

public interface EmployeeService {

	
	public boolean saveEmployee(Employee emp);
	public List getAllEmployee();
	public Employee getEmployeeById(int empId)throws EmployeeException;
	public String deleteEmployeeById(int empId)throws EmployeeException;
}
