package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
	
	public static void choice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hi Admin, you want to do?");
		System.out.println("1. Check registered users");
		System.out.println("2. Check user history");
		System.out.println("3. Check quantity for a product");
		System.out.println("4. Add new items in products");
		
		System.out.println("Select your choice!");
		int choice = sc.nextInt();
		
		if (choice == 1) {
			checkUser();
		}
		
		else if (choice == 2) {
			checkUserHistory();
		}
		
		else if (choice == 3) {
			checkQuant();
		}
		
		sc.close();
	}

	public static void checkUser() {
		try {
			Connection conn = CommonConnection.getConnection();
			String user = "select * from user";
			PreparedStatement ps = conn.prepareStatement(user);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Username >> " +rs.getString(1)+ " ,Name >> " +rs.getString(2));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public static void checkUserHistory() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Please type correct user name to check history!");
			String username = sc.next();
			Connection conn = CommonConnection.getConnection();
			String user = "select * from userhistory where username = ?";
			PreparedStatement ps = conn.prepareStatement(user);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
																			
			while(rs.next()) {
				System.out.println("Username >> " +rs.getString(2)+ " ,Product Id >> " +rs.getInt(3)+ " ,Product Quantity >> " +rs.getInt(4));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		sc.close();
	}
		
	public static void checkQuant() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Please type product Id to check quantity!");
			int id = sc.nextInt();
			Connection conn = CommonConnection.getConnection();
			String user = "select * from products where prodId = ?";
			PreparedStatement ps = conn.prepareStatement(user);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Product Id >> " +rs.getInt(1)+ " ,Product name >> " +rs.getString(2)+ " ,Product Quantity >> " +rs.getInt(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();	
	}
	}
