package ass_3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Travel {
	
	@PostConstruct
	public void mySetUp() {
		System.out.println("Start travelling ");
	}
	
	@PreDestroy
	public void destroySetUp() {
		System.out.println("End Travel");
	}
	
	
	public static void main(String[] args) {
		
		ApplicationContext apx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		Bike b =apx.getBean("bike",Bike.class);
		
		b.run();
		
		AnnotationConfigApplicationContext ap= (AnnotationConfigApplicationContext)apx;
		
		ap.close();
		
	}

}
