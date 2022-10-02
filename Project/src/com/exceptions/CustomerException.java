package com.exceptions;

import com.bean.Customer;

public class CustomerException extends Exception{

	String msg;
	
	public CustomerException() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerException(String msg) {
		super(msg);
	}
	
}
