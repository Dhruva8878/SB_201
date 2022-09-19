package ass_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ass_2")
public class AppConfig {

	@Bean(name="app")
	public String getApp() {
		return "Zomato";
	}
	
	@Bean(name="lt")
	public List<Employee> getList(){
		
		return Arrays.asList(
				new Employee(1,"Ram", 25000),
				new Employee(2,"Rakesh",30000),
				new Employee(3,"Rahul",33000),
				new Employee(4,"Prita",38000),
				new Employee(5,"Sita",40000)
				);
		
	}
	
	@Bean(name="mp")
	public Map<Department, Employee> getMap(){
		
		Map<Department, Employee> map = new HashMap<>();
		
		map.put(new Department(1,"Sales", "Indore"), new Employee(1,"Ram", 25000));
		map.put(new Department(2,"Marketing","Pune"),new Employee(3,"Rahul",33000));
		map.put(new Department(3, "HR","Delhi"),new Employee(2,"Rakesh",30000));
		
		
		return map;
	}
}
