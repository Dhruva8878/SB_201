package ass_3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
	
	private Drawshapes dr;
	
	 public Drawshapes getDr() {
		return dr;
	}
	public void setDr(Drawshapes dr) {
		this.dr = dr;
	}




	public static void main(String[] args) {
			
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			
		   Runner rn= ctx.getBean(Runner.class,"dm");
			
		   rn.getDr().shape();
		    
		}

}
