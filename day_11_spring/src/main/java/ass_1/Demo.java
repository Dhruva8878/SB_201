package ass_1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	
	@Autowired
	List<String> cities;
	
	@Autowired(required = false)
	@Qualifier("Stud")
	List<Student> students;
	
	public static void main(String[] args) {
		
		ApplicationContext apx=new AnnotationConfigApplicationContext(AppConfi.class);
		
		Demo d=apx.getBean("demo",Demo.class);
		
	    System.out.println(d.cities);
	    
	    d.students.forEach(s->System.out.println(s));
	}

}
