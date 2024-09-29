package com.user;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class MainScreen {
	
	public static void welcomeScreen() throws SQLException {
		String username;
		Guest guest = new Guest();
		Scanner sc = new Scanner(System.in);
		System.out.println("***** Hello Welcome to E-Commerce Shopping! *****");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Are you a:-");
		System.out.println("1. Admin");
		System.out.println("2. User Registration");
		System.out.println("3. User Login");
		System.out.println("4. Guest");
		System.out.println("Type your choice from above ");
		int choice = sc.nextInt();
		if (choice == 4) {
			guest.getProd();	
			}
		
		else if (choice == 2) {
			User.registration();
		}
		
		else if (choice == 3) {
			username = User.userLogin();
			Map<Integer, Integer> map = User.prodChoice(username);
			User.buyNow(map, username);
			User.historyUpdate(map, username);
			User.prodUpdate(map);
		}
		
		else if (choice == 1) {
			Admin.choice();	
		}
		
		else {
			try{
				throw new EcommException("Kindly enter the correct choice!");
			}
			catch (RuntimeException rex) {
				System.out.println(rex);
			}
			System.out.println("");
			welcomeScreen();
		}
	sc.close();
	}	
	
	public static void main(String[] args) throws SQLException {
		welcomeScreen();
		
	}

}
