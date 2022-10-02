package com.admindao;

import com.bean.Admin;
import com.exceptions.AdminException;

public interface AdminDaoInter {

	
	
	public  Admin getAdminDetails(String email,String pass) throws AdminException;
}
