package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonConnection {
    // first we make a common connection and use this connection object repeteadly
	public static Connection getConnection() throws SQLException {  //create connection method
		Connection connection=null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "Mysql@123");

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;  
		
	}	
}
