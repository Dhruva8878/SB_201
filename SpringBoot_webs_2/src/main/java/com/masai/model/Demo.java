package com.masai.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import BookController.AuthorController;

public class Demo {
	
	public static void main(String[] args){
		
		ApplicationContext apx=new AnnotationConfigApplicationContext(Appconfig.class);
	 	 
		AuthorController ac= apx.getBean("authorController",AuthorController.class);
	 
		 
	}

}
