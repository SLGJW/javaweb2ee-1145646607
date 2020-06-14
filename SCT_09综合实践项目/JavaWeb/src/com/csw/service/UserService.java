package com.csw.service;

import com.csw.dao.UserDao;

public class UserService {
	UserDao ud=new UserDao();
	public int loginUser(String username, String password) {
		
		return ud.loginUser(username,password);
	}

}
