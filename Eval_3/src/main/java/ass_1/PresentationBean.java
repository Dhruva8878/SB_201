package ass_1;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PresentationBean {

	@Autowired
	private EmployeeService empService;
	
	
	public void insertEmployee(){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter Employee name");
		String name=sc.next();
		System.out.println("enter Employee address");
		String add=sc.next();
		System.out.println("Enter salary");
		int sal=sc.nextInt();
		
		Employee emp=new Employee();
		emp.setEmpName(name);
		emp.setEmpAddress(add);
		emp.setSalary(sal);
		
		empService.saveEmployee(emp);
		
	}
	
	
	public void printAllEmployee(){
	
		List<Employee> list= empService.getAllEmployee();
		
		list.forEach(e->System.out.println(e));
		
	}	
	
	public void searchEmployee() throws EmployeeException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Id");
		
		int id=sc.nextInt();
		
		Employee emp= empService.getEmployeeById(id);
		
		System.out.println(emp);
		
	}
	
	public void deleteEmployee() throws EmployeeException{
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Id");
		
		int id=sc.nextInt();
		
		String msg=empService.deleteEmployeeById(id);
		
		System.out.println(msg);
		
		
	}
	}


	

