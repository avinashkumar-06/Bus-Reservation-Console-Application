package com.admindao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Admin;
import com.exceptions.AdminException;
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

}
