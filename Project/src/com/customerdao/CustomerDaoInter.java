package com.customerdao;

import java.util.List;

import com.bean.Bus;
import com.bean.Customer;
import com.bean.Tickets;
import com.exceptions.CustomerException;

public interface CustomerDaoInter {

	public String addCustomer(Customer customer) throws CustomerException;
	public Customer loginCustomer(String email,String password) throws CustomerException;
	public List<String> allSource() throws CustomerException;
	public List<String> destinationAccordingToSource(String source) throws CustomerException;
	public Bus  busAccordingToSourceAndDestination(String source,String destination,int seatNum) throws CustomerException;
	public String bookAndAddTicketToDataBase(Tickets ticket) throws CustomerException;
	public List<Tickets> getTicketsOfACustomer(int cid) throws CustomerException;
	public String cancelTicketBasedOnTid(int tid,int bid,int seatNum) throws CustomerException;
	
}
