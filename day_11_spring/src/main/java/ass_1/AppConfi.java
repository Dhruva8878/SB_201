package ass_1;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ass_1")
public class AppConfi {
	
	
	@Bean
	public List<String> getList(){
		 
		return Arrays.asList("Delhi","Mumbai","Pune","Indore","Khargone");
	}
	
	@Bean(name = "stud")
	public List<Student> getStud(){
		
		return Arrays.asList(
				new Student(1,"Ram",500),
				new Student(2,"Rakesh", 450),
				new Student(3, "Priya", 460),
				new Student(4,"Mukesh", 300),
				new Student(5,"Shubham", 200)
				);
	}

}
