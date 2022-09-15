package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	
	public static void main(String[] args) {
		
		ApplicationContext apx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Collage clg=apx.getBean("clg",Collage.class);
		
		clg.showDetails();
		
	}
}
