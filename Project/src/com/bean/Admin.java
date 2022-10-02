package com.bean;

public class Admin {

	private int aid;
	private String name;
	private String email;
	private String password;
	
	
	
	
	
	public Admin() {
	}





	public Admin(int aid, String name, String email, String password) {
		super();
		this.aid = aid;
		this.name = name;
		this.email = email;
		this.password = password;
	}





	public int getAid() {
		return aid;
	}





	public void setAid(int aid) {
		this.aid = aid;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
	
}
