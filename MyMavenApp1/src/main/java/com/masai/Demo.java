package com.masai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {
	
	
	public static Connection provideConnection() {
		Connection conn=null; 
		
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
		
		catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	    	 
	    	String src="jdbc:mysql://localhost:3306/db1";
	    	
	    	try{
	    		conn=DriverManager.getConnection(src, "root","rootroot");
				} 
	    	
	    	catch (SQLException e) {	
				e.printStackTrace();
				}
	    
	    	
	    return conn;	
	}
	
    

}
