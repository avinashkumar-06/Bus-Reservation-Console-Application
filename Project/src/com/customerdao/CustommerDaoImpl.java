package com.customerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bean.Bus;
import com.bean.Customer;
import com.bean.Tickets;
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

	@Override
	public List<String> allSource() throws CustomerException {
		List<String> sources = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement(" select DISTINCT  source from Bus");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				sources.add(rs.getString("source"));
			}
			
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		
		return sources;
	}

	@Override
	public List<String> destinationAccordingToSource(String source) throws CustomerException {

		List<String> destinations = new ArrayList<>();
		
		try(Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select DISTINCT  destination from Bus where source=?");
			ps.setString(1, source);
			
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				destinations.add(rs.getString("destination"));
			}
			
			
			
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		
		
		return destinations;
	}

	@Override
	public Bus busAccordingToSourceAndDestination(String source, String destination,int seatNum) throws CustomerException {
		
		Bus bus=null;
		
		try(Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from Bus where source=? AND destination=? AND seats>=? LIMIT 1");
			
			ps.setString(1, source);
			ps.setString(2, destination);
			ps.setInt(3, seatNum);

			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int bid=rs.getInt("bid");
				String name = rs.getString("bname");
				String source1 = rs.getString("source");
				String destination1 = rs.getString("destination");
				String type = rs.getString("type");
				int seats=rs.getInt("seats");
				String departure = rs.getString("departure");
				String arrival = rs.getString("arrival");
				int fare=rs.getInt("fare");
				String contact = rs.getString("contact");
				
				bus=new Bus(bid,name,source1,destination1,type,seats,departure,arrival,fare,contact);
				
			}else {
				throw new CustomerException("Sorry! Not enough seats are available at this moment as per your need.");
			}
			
			
			
			
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		
		
		return bus;
	}

	@Override
	public String bookAndAddTicketToDataBase(Tickets ticket) throws CustomerException {
		
		String msg="Ticket Not booked";
		
		try(Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps =
					conn.prepareStatement("insert into Customer_Tickets (cid,bid,bname,source,destination,btype,fare,seatNum,contact,departure,arrival) values(?,?,?,?,?,?,?,?,?,?,?)");
			
			ps.setInt(1,ticket.getCid());
			ps.setInt(2, ticket.getBid());
			ps.setString(3, ticket.getBname());
			ps.setString(4, ticket.getSource());
			ps.setString(5, ticket.getDestination());
			ps.setString(6, ticket.getBtype());
			ps.setInt(7,ticket.getFare());
			ps.setInt(8,ticket.getSeatNum());
			ps.setString(9, ticket.getContact());
			ps.setString(10, ticket.getDeparture());
			ps.setString(11, ticket.getArrival());


			int check=ps.executeUpdate();
			
			if(check>0) {
				msg="Ticket Booked Successfully";
				
				PreparedStatement ps1 = conn.prepareStatement("update Bus set seats=seats-? where bid=?");
				ps1.setInt(1, ticket.getSeatNum());
				ps1.setInt(2, ticket.getBid());
				
				ps1.executeUpdate();
				
			}else {
				throw new CustomerException("Ticket not booked.Please try again.");
			}

			
			
			
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
			
		}
		
		
		
		
		
		
		
		
		
		
		return msg;
	}

	
}
