package com.CustomerUseCaseAndMain;

import java.util.List;
import java.util.Scanner;

import com.bean.Bus;
import com.bean.Customer;
import com.bean.Tickets;
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
			
			customerDashhBoard(customer);	
			
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
	
	
	
	public static void customerDashhBoard(Customer customer) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the customer DashBoard");
		System.out.println("==================================== \n");
		
		System.out.println("1.Book Ticket       2.Cancel  Ticket \n");
		
		System.out.println("Please Enter your choice: ");
		int customerChoice= sc.nextInt();
		
		if(customerChoice==1) {
			bookTickets(customer);
		}
		
	}
	
	public static void bookTickets(Customer customer) {
		Scanner sc = new Scanner(System.in);
		CustomerDaoInter  intr = new CustommerDaoImpl();
		
//		Source selection
		System.out.println("Please select your source");
		System.out.println("------------------");
		
		List<String> sources=null;
		try {
			sources = intr.allSource();
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		
		for(int i=0;i<sources.size();i++) {
			System.out.println(i+". "+sources.get(i).toUpperCase());
		}
		int sourceChoice=sc.nextInt();
		String source = sources.get(sourceChoice);
		System.out.println("\n");
		
//		Destination selection
		System.out.println("Select your destination.");
		
		List<String> destinations=null;
		try {
			destinations = intr.destinationAccordingToSource(source);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		
		for(int i=0;i<destinations.size();i++) {
			System.out.println(i+". "+destinations.get(i).toUpperCase());
		}
		int destinationChoice=sc.nextInt();
		String destination = destinations.get(destinationChoice);
		
		System.out.println("\n");
		
//		Number of seats
		System.out.println("Enter how many seats you want: ");
		int numOfSeats=sc.nextInt();
	
//		Get bus according to source and destination.
		
		Bus bus =null;
		try {
			 bus = intr.busAccordingToSourceAndDestination(source, destination,numOfSeats);
			
			
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
			System.out.println("Your booking has failed but you can try following options: ");
			System.out.println("-------------------------------------------------------------");
			System.out.println("1.Re-try Booking    2.Go to Customer Dashboard");
			System.out.println("3.Exit the application.");
			System.out.println("Enter your choice:");
			int usrchoi3=sc.nextInt();
			
			if(usrchoi3==1) {
				bookTickets(customer);
			}
			else if(usrchoi3==2) {
				customerDashhBoard(customer);
			}
			else if(usrchoi3==3) {
				System.exit(0);
			}
			else {
				System.out.println("Invalid choice. Please Start again.");
				System.exit(0);
			}
		}
	
//		Creating Ticket Data to insert it into Customer_Ticekts table.
		
		Tickets ticket=new Tickets();
		ticket.setCid(customer.getCid());
		ticket.setBid(bus.getBid());
		ticket.setBname(bus.getBname());
		ticket.setSource(bus.getSource());
		ticket.setDestination(bus.getDestination());
		ticket.setDeparture(bus.getDeparture());
		ticket.setArrival(bus.getArrival());
		ticket.setBtype(bus.getType());
		ticket.setContact(bus.getContact());
		ticket.setSeatNum(numOfSeats);
		ticket.setFare(numOfSeats*bus.getFare());
		
//		Checking booked or not.
		try {
			String msg = intr.bookAndAddTicketToDataBase(ticket);
			System.out.println(msg);
			
		    System.out.println("Your Bus name is "+ticket.getBname()+" and it will depart at "+ticket.getDeparture()+
		    		" from "+ticket.getSource()+" and will reach "+ticket.getDestination()+" at "+ticket.getArrival());
		    
		    System.out.println("You have booked "+ticket.getSeatNum()+" seats and bill is "+ticket.getFare());
		    
		    System.out.println("Please cotact bus manager for any help at mobile number "+ticket.getContact());
		    
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
			System.out.println("Your booking has failed but you can try following options: ");
			System.out.println("-------------------------------------------------------------");
			System.out.println("1.Re-try Booking    2.Go to Customer Dashboard");
			System.out.println("3.Exit the application.");
			System.out.println("Enter your choice:");
			int usrchoi3=sc.nextInt();
			
			if(usrchoi3==1) {
				bookTickets(customer);
			}
			else if(usrchoi3==2) {
				customerDashhBoard(customer);
			}
			else if(usrchoi3==3) {
				System.exit(0);
			}
			else {
				System.out.println("Invalid choice. Please Start again.");
				System.exit(0);
			}
		}
	
	}
	
	
	
	public static void main(String[] args) {
		
//		bookTickets(null);
		
	}
}
