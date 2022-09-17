package com.masai;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	
	private Map<Department, Employee> theMap;
	
	
	
	
	public Map<Department, Employee> getTheMap() {
		return theMap;
	}

	public void setTheMap(Map<Department, Employee> theMap) {
		this.theMap = theMap;
	}

	public void myInit(){
	   System.out.println("inside myInit method");
	}
	
	public void cleanUp(){
	   System.out.println("inside cleanUp method");
	}
	
	public void showDetails(){
	   System.out.println("inside showDetails of Demo class");
	   
	   System.out.println(theMap);
	   
	//print all the details of all the employees department-wise.
	}
	
	
	public static void main(String[] args) {
		
		ApplicationContext apx=new ClassPathXmlApplicationContext("applicationContext.xml");
	
		Demo d =apx.getBean("dm",Demo.class);
		
		d.showDetails();
		
		ClassPathXmlApplicationContext clc=(ClassPathXmlApplicationContext)apx;
		
		clc.close();
	}

}
