package ass_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
	
	public static void main(String[] args) throws EmployeeException {
		
		ApplicationContext apx=new AnnotationConfigApplicationContext(Appconfig.class);
		
		PresentationBean px= apx.getBean("presentationBean",PresentationBean.class);
	    
		px.insertEmployee();
//		px.searchEmployee();
//		px.printAllEmployee();
//		px.deleteEmployee();
	}

}
