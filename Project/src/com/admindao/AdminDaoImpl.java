package com.admindao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Admin;
import com.bean.Bus;
import com.bean.Customer;
import com.exceptions.AdminException;
import com.exceptions.BusException;
import com.exceptions.CustomerException;
import com.utility.DBUtil;

public class AdminDaoImpl implements AdminDaoInter {

	public Admin getAdminDetails(String email, String pass) throws AdminException {

		Admin ad=null;
		
		try(Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from Admin where email=?");
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int a=rs.getInt("aid");
				String n=rs.getString("name");
				String e=rs.getString("email");
			    String p=rs.getString("password");
				
			    ad=new Admin(a,n,e,p);
			}else {
				throw new AdminException("No Admin found with given email.");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AdminException(e.getMessage());
		}
		
		return ad;
	}
	
//	(int bid, String bname, String source, String destination, String type, int seats, String departure,
//			String arrival, int fare, String contact)

	@Override
	public String addNewBus(Bus bus) throws BusException {
		
		String msg="Bus not added.";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into Bus values(?,?,?,?,?,?,?,?,?,?)");
			
			ps.setInt(1,bus.getBid());
			ps.setString(2, bus.getBname());
			ps.setString(3, bus.getSource());
			ps.setString(4, bus.getDestination());
			ps.setString(5, bus.getType());
			ps.setInt(6, bus.getSeats());
			ps.setString(7, bus.getDeparture());
			ps.setString(8, bus.getArrival());
			ps.setInt(9, bus.getFare());
			ps.setString(10, bus.getContact());

			int n= ps.executeUpdate();
			
			if(n<0) {
				throw new BusException("Bus not added");
			}else {
				msg="Bus Added";
			}
			
		} catch (SQLException e) {
			throw new BusException(e.getMessage());
		}
		
		
		
		
		return msg;
	}

	@Override
	public List<Bus> viewAllBus() throws BusException {
		
		List<Bus> buses = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from Bus");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Bus bus =  new Bus(); 
					
				bus.setBid(rs.getInt("bid"));
				bus.setBname(rs.getString("bname"));
				bus.setSource(rs.getString("source"));
				bus.setDestination(rs.getString("destination"));
				bus.setType(rs.getString("type"));
				bus.setSeats(rs.getInt("seats"));
				bus.setDeparture(rs.getString("departure"));
				bus.setArrival(rs.getString("arrival"));
				bus.setFare(rs.getInt("fare"));
				bus.setContact(rs.getString("contact"));

				buses.add(bus);

				
			}
			
			if(buses.isEmpty()) {
				throw new BusException("No bus found in the database.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BusException(e.getMessage());
		}
		
		
		
		return buses;
	}

	@Override
	public List<Customer> viewAllCustomer() throws CustomerException {
		
		
		List<Customer> customers = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
				PreparedStatement ps = conn.prepareStatement("select * from Customer");
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					Customer customer =  new Customer(); 
						
					customer.setCid(rs.getInt("cid"));
					customer.setAge(rs.getInt("age"));
					customer.setName(rs.getString("name"));
					customer.setGender(rs.getString("gender"));
					customer.setEmail(rs.getString("email"));
					customer.setPassword("No display");
					
					customers.add(customer);
					
				}
				
				if(customers.isEmpty()) {
					throw new CustomerException("No customer found in the database.");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new CustomerException(e.getMessage());
			}
		
		
		return customers;
	}



	

}
