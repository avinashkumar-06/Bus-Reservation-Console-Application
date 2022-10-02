package com.exceptions;

public class BusException extends Exception{
	
	String msg;

	
	
	public BusException() {
	}



	public BusException(String msg) {
		super(msg);
	}
	

}
