package com.customerdao;

import com.bean.Customer;
import com.exceptions.CustomerException;

public interface CustomerDaoInter {

	public String addCustomer(Customer customer) throws CustomerException;
	public Customer loginCustomer(String email,String password) throws CustomerException;
	
}
