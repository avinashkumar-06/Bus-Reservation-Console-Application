package com.customerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Customer;
import com.exceptions.CustomerException;
import com.utility.DBUtil;

public class CustommerDaoImpl implements CustomerDaoInter{

	@Override
	public String addCustomer(Customer customer) throws CustomerException {
		String msg="Not registered";
		
		try(Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps =
					conn.prepareStatement("insert into Customer(name,age,gender,email,password) values(?,?,?,?,?)");
			
			ps.setString(1, customer.getName());
			ps.setInt(2, customer.getAge());
			ps.setString(3, customer.getGender());
			ps.setString(4, customer.getEmail());
			ps.setString(5, customer.getPassword());

			int check = ps.executeUpdate();
			
			if(check>0) {
				System.out.println("Registration Succesfull.");
			}else {
				throw new CustomerException("Customer not added");
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		
		
		
		
		
		
		return null;
	}

	@Override
	public Customer loginCustomer(String email, String password) throws CustomerException {
		
		Customer customer = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from Customer where email = ?");
			ps.setString(1, email);
			
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				customer = new Customer();
				
				customer.setCid(rs.getInt("cid"));
				customer.setAge(rs.getInt("age"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				
			}else {
				throw new CustomerException("Email not found. Check email or Register if you are a new customer.");
			}
			
			if(!customer.getPassword().equals(password)) {
				throw new CustomerException("Password is incorrect.");
			}
			
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		
		
		
		
		
		return customer;
	}

	
}
