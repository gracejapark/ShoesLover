package com.mvc;

public class CSRBean {
	int employeeid;
	String userName;
	String passwd;
	String firstname;
	String lastname;
	
	public CSRBean(int employeeid, String userName,String passwd,String firstname,String lastname) {
		this.employeeid = employeeid;
		this.userName = userName;
		this.passwd = passwd;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public CSRBean() {
		this.employeeid = 0 ;
		this.userName = "";
		this.passwd = "";
		this.firstname = "";
		this.lastname = "";
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}

