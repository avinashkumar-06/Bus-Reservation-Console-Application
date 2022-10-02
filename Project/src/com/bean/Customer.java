package com.bean;

public class Customer {

	private int cid;
	private String name;
	private int age;
	private String gender;
	private String email;
	private String password;
	


	public Customer(int cid, String name, int age, String gender, String email, String password) {
		this.cid = cid;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.password = password;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
		return "Customer [name=" + name + ", age=" + age + ", gender=" + gender + ", email=" + email
				+ ", password=" + password + "]";
	}

	
	
	
	
	
	
}
