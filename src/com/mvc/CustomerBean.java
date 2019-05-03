package com.mvc;

import java.io.Serializable;

public class CustomerBean implements Serializable{
	int custid;
	String usrname;
	String passwd;
	String firstname;
	String lastname;
	String address;
	String city;
	String postalcd;
	
	public CustomerBean(int custid, String usrname, String passwd, String firstname, String lastname, String address, String city, String postalcd)
	{
	this.custid = custid;
	this.usrname = usrname;
	this.passwd = passwd;
	this.firstname = firstname;
	this.lastname = lastname;
	this.address = address;
	this.city = city;
	this.postalcd = postalcd;

	}
	public CustomerBean()
	{
		this.custid = 0;
		this.usrname = "";
		this.passwd = "";
		this.firstname = "";
		this.lastname = "";
		this.address = "";
		this.city = "";
		this.postalcd ="";

	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalcd() {
		return postalcd;
	}
	public void setPostalcd(String postalcd) {
		this.postalcd = postalcd;
	}
	
}
