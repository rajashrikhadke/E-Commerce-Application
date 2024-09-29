package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Guest {
	
	Connection con = null;

	public void getProd() {
	System.out.println("Thanks for visiting E-Commerce Shopping! ");
	System.out.println("We have these products in our store: ");
	
	try {
		con = CommonConnection.getConnection();
		
		PreparedStatement ps = con.prepareStatement("select * from products");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("Product Id>> " +rs.getInt(1));
			System.out.println("Product Name>> " +rs.getString(2));
			System.out.println("Product Price>> " +rs.getFloat(4));
			System.out.println("Product Quantity>>>" +rs.getInt(5));
		}
					
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
  }
}
