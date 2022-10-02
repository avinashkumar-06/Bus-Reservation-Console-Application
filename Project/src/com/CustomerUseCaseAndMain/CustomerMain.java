package com.CustomerUseCaseAndMain;

import java.util.Scanner;

import com.bean.Customer;
import com.customerdao.CustomerDaoInter;
import com.customerdao.CustommerDaoImpl;
import com.exceptions.CustomerException;

public class CustomerMain {

	
	public static void registerCustomer() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to User Registration page: ");
		
		System.out.println("Please enter your name: ");
		String name = sc.nextLine();
		
		System.out.println("Please choose your gender:");
		System.out.println("1.Male   2.Female");
		int gench=sc.nextInt();
		String gender;
		if(gench==1) {
			gender="male";
		}else {
			gender="female";
		}
		
		System.out.println("Please enter your age: ");
		int age = sc.nextInt();
		
		String email= sc.nextLine();
		System.out.println("Enter the email to register: ");
		email=sc.nextLine();
		
		
		System.out.println("Please enter password for your account: ");
		String password= sc.nextLine();		
		
		Customer customer =  new Customer();
		customer.setName(name);
		customer.setAge(age);
		customer.setGender(gender);
		customer.setEmail(email.toLowerCase());
		customer.setPassword(password);
		
		CustomerDaoInter  intr = new CustommerDaoImpl();
		
		try {
			String msg=intr.addCustomer(customer);
			System.out.println("You will be redirected to login page.");
			existingCustomer();
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void existingCustomer() {
		Scanner sc = new Scanner(System.in);
		CustomerDaoInter  intr = new CustommerDaoImpl();
		
		System.out.println("Customer Login page");
		System.out.println("======================");
		
		System.out.println("please enter your registered email:");
		String email=sc.nextLine();
		
		System.out.println("Please enter your account password: ");
		String password = sc.nextLine();
		
		Customer customer=null;
		
		try {
			customer=intr.loginCustomer(email, password);
			
			
			
			
			
			
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
			System.out.println("Choose: \n");
			System.out.println("1.Re-Attempt 2.Register 3.Exit.");
			int choi1=sc.nextInt();
			
			if(choi1==1) {
				existingCustomer();
			}
			else if(choi1==2) {
				registerCustomer();
			}
			else if(choi1==3) {
				System.exit(0);
			}else {
				System.out.println("Invalid choice. Application is closing. Start again.");
				System.exit(0);
			}
			
		}
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
	}
}
