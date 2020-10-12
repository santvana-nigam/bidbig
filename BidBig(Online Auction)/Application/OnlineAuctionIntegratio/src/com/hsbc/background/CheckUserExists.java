package com.hsbc.background;

import com.hsbc.dao.UserDAOImpl;

public class CheckUserExists {
	
	public CheckUserExists() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean ifexists(String username,String password)
	{
		UserDAOImpl daoImpl=new UserDAOImpl();
		String passwordtable=daoImpl.getPassword(username);
		if(password.equals(passwordtable))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
