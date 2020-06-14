package com.csw.bean;

import java.util.Date;

public class Student {
	private int sid;
	private String sname;
	private int sex;
	private String shobbies;
	private String sclass;
	private Date birthday;
	private String edu;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(String sname, int sex, String shobbies, String sclass, Date birthday, String edu) {
		super();
		this.sname = sname;
		this.sex = sex;
		this.shobbies = shobbies;
		this.sclass = sclass;
		this.birthday = birthday;
		this.edu = edu;
	}

	public Student(int sid, String sname, int sex, String shobbies, String sclass, Date birthday, String edu) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.shobbies = shobbies;
		this.sclass = sclass;
		this.birthday = birthday;
		this.edu = edu;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getShobbies() {
		return shobbies;
	}
	public void setShobbies(String shobbies) {
		this.shobbies = shobbies;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sex=" + sex + ", shobbies=" + shobbies + ", sclass="
				+ sclass + ", birthday=" + birthday + ", edu=" + edu + "]";
	}
	
}
