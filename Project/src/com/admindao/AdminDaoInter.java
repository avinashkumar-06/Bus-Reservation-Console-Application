package com.admindao;

import java.util.List;

import com.bean.Admin;
import com.bean.Bus;
import com.bean.Customer;
import com.exceptions.AdminException;
import com.exceptions.BusException;
import com.exceptions.CustomerException;

public interface AdminDaoInter {

	
	
	public  Admin getAdminDetails(String email,String pass) throws AdminException;
	public  String addNewBus(Bus bus) throws BusException;
	public List<Bus> viewAllBus() throws BusException;
	public List<Customer> viewAllCustomer() throws CustomerException;
	
}
