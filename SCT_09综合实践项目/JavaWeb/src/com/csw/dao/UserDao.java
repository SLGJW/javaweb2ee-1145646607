package com.csw.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.csw.utils.MyUtils;

public class UserDao {

	public int loginUser(String username, String password) {
		String sql="select count(*) from user where username=? and password=?";
		long l=0;
		try {
			l =(long) MyUtils.qr.query(sql, new ScalarHandler(),username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (int)l;
	}

}
