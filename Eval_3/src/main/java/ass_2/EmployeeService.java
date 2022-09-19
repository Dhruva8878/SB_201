package ass_2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

	@Autowired(required = false)
	@Qualifier("mp")
	private Map<Department, Employee> theMap; 
	
	@Autowired(required = false)
	@Qualifier("lt")
	private List<Employee> theList; 
	
	@Autowired(required = false)
	@Qualifier("app")
	private String appName; 
	
	
	public void printMap(){
		
		System.out.println(theMap);
	}
	
	public void printList() {
		
		List<Employee> newList=theList.stream()
				                      .sorted()
				                      .collect(Collectors.toList());
		
		newList.forEach(e->System.out.println(e));
		
		
	}
	public void printAppName(){
		System.out.println(appName);
	}

	
	public static void main(String[] args) {
		
		ApplicationContext apx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmployeeService emp= apx.getBean("employeeService",EmployeeService.class);
	     
	    emp.printList();
	    emp.printAppName();
	}
	
}
