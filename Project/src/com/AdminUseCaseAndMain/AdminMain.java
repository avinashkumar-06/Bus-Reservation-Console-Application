package com.AdminUseCaseAndMain;

import java.util.List;
import java.util.Scanner;

import com.admindao.AdminDaoImpl;
import com.admindao.AdminDaoInter;
import com.bean.Admin;
import com.bean.Bus;
import com.exceptions.AdminException;
import com.exceptions.BusException;

public class AdminMain {

	public static void dashBoard() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Please select the task");
		System.out.println("========================");
		
		System.out.println("1.Add A bus                   2.View All Buses \n");
		System.out.println("3.View all Customer           4.View All Tickets \n");

		int choice = sc.nextInt();
		
		switch(choice) {
		
		case 1:
				
			System.out.println("Enter the bus id: ");
			int bid=sc.nextInt();
			
			String bname = sc.nextLine();
			System.out.println("Enter bus Name: ");
			bname = sc.nextLine();
		
			
			System.out.println("Enter source: ");
			String source=sc.nextLine();
			
			
			System.out.println("Enter Destination: ");
			String destination = sc.nextLine();
			
			System.out.println("Choose the bus type(Ac or Non-Ac): ");
			System.out.println("1.AC   2.NON-AC");
			int t=sc.nextInt();
			String type;
			if(t==1) {
				type="ac";
			}else {
				type="not-ac";
			}
			
			System.out.println("Enter Available seats: ");
			int seats=sc.nextInt();
			
			String departure=sc.nextLine();
			System.out.println("Enter departure time: ");
			 departure=sc.nextLine();
			
			
			System.out.println("Enter arrival time at destination:");
			String arrival = sc.nextLine();
			
			System.out.println("Enter fare for one ticket:");
			int fare =sc.nextInt();
			
			String contact=sc.nextLine();
			System.out.println("Enter contact information of bus manager: ");
			contact=sc.nextLine();
			
			Bus bus =new Bus(bid, bname,  source,  destination,  type,  seats,  departure,
					 arrival,  fare,  contact);
			
			AdminDaoInter intr = new AdminDaoImpl();
			try {
				String msg=intr.addNewBus(bus);
				System.out.println(msg);
			} catch (BusException e) {
				System.out.println(e.getMessage());
			}
			
			break;
			
		case 2:
			AdminDaoInter intr1 = new AdminDaoImpl();
			try {
				List<Bus> buses=intr1.viewAllBus();
				
				for(Bus b : buses) {
					System.out.println(b);
				}
				
				
			} catch (BusException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		}
		
	}
	
	public static void adminFunction(String email,String password) {
		
		AdminDaoInter  intr = new AdminDaoImpl();
		
		try {
			Admin ad =intr.getAdminDetails(email.toLowerCase(), password.toLowerCase());
			
			if(ad.getPassword().equals(password)) {
				
				dashBoard();
				
			}else {
				System.out.println("Please check your password and try again.Passwords are case sensitive.");
				
			}
	
			
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		
//		dashBoard();
		
		
		
		
		
		
	}

}
