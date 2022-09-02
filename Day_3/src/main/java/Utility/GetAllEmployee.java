package Utility;

import java.util.List;

import com.DAO.EmployeeDao;
import com.Emplo.Employee;
import com.daoImpl.EmployeeDaoImpl;

public class GetAllEmployee {
	
	public static void main(String[] args) {
		
		EmployeeDao emp=new EmployeeDaoImpl();
		
		List<Employee> list=emp.getAllEmployee();
		
		list.forEach(e->System.out.println(e));
	}

}
