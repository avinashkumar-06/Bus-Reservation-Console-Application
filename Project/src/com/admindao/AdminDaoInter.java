package com.admindao;

import java.util.List;

import com.bean.Admin;
import com.bean.Bus;
import com.exceptions.AdminException;
import com.exceptions.BusException;

public interface AdminDaoInter {

	
	
	public  Admin getAdminDetails(String email,String pass) throws AdminException;
	public  String addNewBus(Bus bus) throws BusException;
	public List<Bus> viewAllBus() throws BusException;
	
}
