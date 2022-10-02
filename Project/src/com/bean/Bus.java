package com.bean;

public class Bus {

	
	
	 private int bid;
	 private String bname;       
	 private String source;    
	 private String destination; 
	 private String type     ;   
	 private int seats      ; 
	 private String departure;  
	 private String arrival ;    
	 private int fare    ;   
	 private String contact;
	 
	 
	public Bus(int bid, String bname, String source, String destination, String type, int seats, String departure,
			String arrival, int fare, String contact) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.source = source;
		this.destination = destination;
		this.type = type;
		this.seats = seats;
		this.departure = departure;
		this.arrival = arrival;
		this.fare = fare;
		this.contact = contact;
	}


	public Bus() {
	}


	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public String getBname() {
		return bname;
	}


	public void setBname(String bname) {
		this.bname = bname;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getSeats() {
		return seats;
	}


	public void setSeats(int seats) {
		this.seats = seats;
	}


	public String getDeparture() {
		return departure;
	}


	public void setDeparture(String departure) {
		this.departure = departure;
	}


	public String getArrival() {
		return arrival;
	}


	public void setArrival(String arrival) {
		this.arrival = arrival;
	}


	public int getFare() {
		return fare;
	}


	public void setFare(int fare) {
		this.fare = fare;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	@Override
	public String toString() {
		return "Bus [bid=" + bid + ", bname=" + bname + ", source=" + source + ", destination=" + destination
				+ ", type=" + type + ", seats=" + seats + ", departure=" + departure + ", arrival=" + arrival
				+ ", fare=" + fare + ", contact=" + contact + "]";
	}
	
	
	
	
	
	
	
	
}
