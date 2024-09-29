package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class User {
// then 2nd step create a user class 
public static void registration() {  //create static method for user registration
	
	try {
		Connection userConn = CommonConnection.getConnection();
		// use common connection 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your username>> ");
		String username = sc.next();
		
		System.out.println("Enter your firstname>> ");
		String firstname = sc.next();
		
		
		System.out.println("Enter your lastname>> ");
		String lastname = sc.next();
		
		System.out.println("Enter your password>> ");
		String password = sc.next();
		
		System.out.println("Enter your city>> ");
		String city = sc.next();
		
		System.out.println("Enter your email>> ");
		String email = sc.next();
		
		System.out.println("Enter your mobnum>> ");
		String mobnum = sc.next();

		
		PreparedStatement ps = userConn.prepareStatement("Insert into user values (?,?,?,?,?,?,?)");
		ps.setString(1, username);
		ps.setString(2, firstname);
		ps.setString(3,lastname);
		ps.setString(4,password);
		ps.setString(5,city);
		ps.setString(6,email);
		ps.setString(7,mobnum);
		
		ps.executeUpdate();
		
		System.out.println("User Created Successfully");
		
		userConn.close();
		ps.close();
	} 
	
	catch (SQLException e) {
		e.printStackTrace();
	}
	
}

public static String userLogin() {  // create method for user login
	Guest guest = new Guest(); // create Guest object for access getProd method 
	Scanner sc = new Scanner(System.in);
	System.out.println("");
	System.out.println("Welcome to E-Commerce Shopping");
	System.out.println("Enter your username");
	String username = sc.next();
	System.out.println("Enter your password");
	String password = sc.next();
	String checkPassword = "";
	try {
		Connection conn = CommonConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement("select pasasword from user where username = ?");
		
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			checkPassword = rs.getString(1);
		}		
	} 
	catch (SQLException e) {

		e.printStackTrace();
	}
	
	if(checkPassword.equals(password)) {
		/* if condition checks the login password & current password is same or not. 
	if passwords are match then shows the message login successful Otherwise wrong input
	*/
		System.out.println("****************");
		System.out.println("Login Successful");
		System.out.println("****************");
		System.out.println("");
		guest.getProd();   //after login shows the product list to user
		
	}
	
	else {
		try{
			throw new EcommException("Invalid username/password!");
			// create EcommException class For exception & extends class with 
			//RuntimeException and pass the exception message meaningful
		}
		catch(RuntimeException rex) {
			System.out.println(rex);
		}
		
		userLogin();
		// if user write incorrect id/pass then system will shows again userlogin() 
	}

	return username;
}

	public static Map<Integer, Integer> prodChoice(String username) throws SQLException {
		String uname = username;
		int checkQuant = 0;
		Map<Integer, Integer> map = new LinkedHashMap<>(); // prodquant,
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("How many products do you want?");
		int prodCount = sc.nextInt();  //2
		
		for(int i=1; i<=prodCount;i++) {
		System.out.println("Enter the product id to buy product>>");
		int prodId = sc.nextInt(); //102
		System.out.println("Enter the quantity of the product>>");
		int prodQuant = sc.nextInt();  //1
		
		try {
			Connection conn = CommonConnection.getConnection();
			PreparedStatement ps =  conn.prepareStatement("select prodQuant from products where prodId = ?");
			ps.setInt(1, prodId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				checkQuant = rs.getInt(1);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(checkQuant >= prodQuant) {
/*
 *  if product quant is greater than check quantity then system ask do u want to 
 *  add these products otherwise shows the message Quantity not available
 */
			map.put(prodId, prodQuant);
		}
		
		else {
			try{
				throw new EcommException("Quanity not available!");
			}
			catch (RuntimeException rex) {
				System.out.println(rex);
			}
			
			System.out.println("Please enter the product details again");
			prodChoice(uname);  //call method again
			}
		}
		return map;
	}
		
public static void buyNow(Map<Integer, Integer> map, String username) throws SQLException {
	Scanner sc = new Scanner(System.in);
	double bill = 0;
	double prodPrice = 0;
	System.out.println("Do you want to add these item/items to be added in the cart");
		System.out.println("Yes/No");
		
		String cartChoice = sc.next();
		
		if(cartChoice.equalsIgnoreCase("Yes")) {
			Connection conn = CommonConnection.getConnection();
				System.out.println("The product has been added to cart");
				try {
					Set<Integer> s = map.keySet();  //Set used bcoz duplicates are not allowed.
					Iterator<Integer> itr = s.iterator();
					while(itr.hasNext()) {
						int n=itr.next();
						PreparedStatement ps = conn.prepareStatement("select prodPrice FROM products where prodId = ?");						
						ps.setInt(1, n);
						ResultSet rs = ps.executeQuery();
						while(rs.next()) {
							prodPrice = rs.getDouble(1);
						}
						
						bill = bill + (prodPrice * map.get(n));  // bill = bill + (10000  *2)
					}
					
					System.out.println(username+ ", your bill is " +bill+ " Rs.");
				}
				
				catch(RuntimeException rex) {
					System.out.println(rex);
				}
			
		}
		
			else {
			prodChoice(username);
			}
			
	sc.close();	
	}

public static void historyUpdate(Map<Integer, Integer> map, String username) throws SQLException {
	Scanner sc = new Scanner(System.in);
			Connection conn = CommonConnection.getConnection();
			System.out.println("User history updated");
		try {
			Set<Integer> s = map.keySet();
			Iterator<Integer> itr = s.iterator();
			while(itr.hasNext()) {
				int n=itr.next();
				PreparedStatement ps = conn.prepareStatement("insert into userhistory ( username, prodId, prodQuant) values (?,?,?);");
				ps.setString(1, username);
				ps.setInt(2, n);
				ps.setInt(3, map.get(n));
				ps.executeUpdate();
				
			}
			
		}
		
		catch(RuntimeException rex) {
			System.out.println(rex);
		}
					
	System.out.println("User history updated");
		
	sc.close();	
	}

public static void prodUpdate(Map<Integer, Integer> map) throws SQLException {
	Connection conn = CommonConnection.getConnection();
	int prodQuant = 0;
	try {
		Set<Integer> s = map.keySet();
		Iterator<Integer> itr = s.iterator();
		while(itr.hasNext()) {
			int prodID=itr.next();
			PreparedStatement ps = conn.prepareStatement("SELECT prodQuant FROM products where prodId = ?");
			ps.setInt(1, prodID);	
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				prodQuant = rs.getInt(1);
			}
			prodQuant = prodQuant - map.get(prodID);
			PreparedStatement ps1 = conn.prepareStatement("UPDATE products SET prodQuant = ? WHERE prodId = ? ");
			ps1.setInt(1, prodQuant);
			ps1.setInt(2, prodID);
			ps1.executeUpdate();
		}
		
	}
	
	catch(RuntimeException rex) {
		System.out.println(rex);
	}
	
	
}

}
