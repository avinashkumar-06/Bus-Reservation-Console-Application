package com.bean;

public class Tickets {
	
	
		private int tid;
		private int cid;
		private int bid;
		private String bname;
		private String source;
		private String destination;
		private String btype;
		private int fare;
		private int seatNum;
		private String contact;
		private String departure;
		private String arrival;
	

		public Tickets() {
			
		}


		public Tickets(int tid, int cid, int bid, String bname, String source, String destination, String btype,
				int fare, int seatNum, String contact, String departure, String arrival) {
			super();
			this.tid = tid;
			this.cid = cid;
			this.bid = bid;
			this.bname = bname;
			this.source = source;
			this.destination = destination;
			this.btype = btype;
			this.fare = fare;
			this.seatNum = seatNum;
			this.contact = contact;
			this.departure = departure;
			this.arrival = arrival;
		}


		public int getTid() {
			return tid;
		}


		public void setTid(int tid) {
			this.tid = tid;
		}


		public int getCid() {
			return cid;
		}


		public void setCid(int cid) {
			this.cid = cid;
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


		public String getBtype() {
			return btype;
		}


		public void setBtype(String btype) {
			this.btype = btype;
		}


		public int getFare() {
			return fare;
		}


		public void setFare(int fare) {
			this.fare = fare;
		}


		public int getSeatNum() {
			return seatNum;
		}


		public void setSeatNum(int seatNum) {
			this.seatNum = seatNum;
		}


		public String getContact() {
			return contact;
		}


		public void setContact(String contact) {
			this.contact = contact;
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


		@Override
		public String toString() {
			return "Tickets [tid=" + tid + ", cid=" + cid + ", bid=" + bid + ", bname=" + bname + ", source=" + source
					+ ", destination=" + destination + ", btype=" + btype + ", fare=" + fare + ", seatNum=" + seatNum
					+ ", contact=" + contact + ", departure=" + departure + ", arrival=" + arrival + "]";
		}

		
	

}
