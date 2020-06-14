package com.csw.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyUtils {
	public static QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
	
	public static String arrayToString(String[] shobby) {
		String str="";
		for(String s:shobby) {
			str+=s+",";
		}
		return str.substring(0,str.length()-1);
	}

	public static Date stringToDate(String bir) {
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		Date d=new Date();
		try {
			d = sf.parse(bir);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
		
	}
}
