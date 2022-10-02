package com.utility;

import java.io.IOException;
import java.util.Scanner;

import com.AdminUseCaseAndMain.AdminMain;
import com.CustomerUseCaseAndMain.CustomerMain;


public class Main {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please select your role: ");
		System.out.println("===========================");
		System.out.println("1.Admin        2.Customer");
		int userChoice=sc.nextInt();
		
		switch (userChoice) {
		case 1:    
			System.out.println("Welcome to Admin Login page");
			System.out.println("===========================");
			
			String username=sc.nextLine();
			System.out.println("Please enter your registered email: ");
			username=sc.nextLine();
			
			System.out.println("Please enter your password: ");
			String password=sc.nextLine();
			
			AdminMain.adminFunction(username, password);
			
			
			
			break;
		
		case 2:
			
			System.out.println("Customer Selection Page: ");
			System.out.println("===========================");
			
			System.out.println("1.New Customer? Register.   2.Existing customer? Login");
			
			System.out.println("Please select your option: ");
			int ch2=sc.nextInt();
			
			if(ch2==1) {
				CustomerMain.registerCustomer();
			}
			else if(ch2==2) {
				CustomerMain.existingCustomer();
			}
			
			
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + userChoice);
		}
		
		
		
		
		
	}
}
