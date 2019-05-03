package com.mvc;

import java.sql.Timestamp;

public class OrderResultBean {
	int orderid;
	int custid;
	int itemid;
	Timestamp orderDate;
	int quantity;
	String status;
	String itemname;
	String category;
	double shoeSize;
	double price;
	String shoeType;
	
	public OrderResultBean(int orderid, int custid, int itemid, Timestamp orderDate, int quantity, String status,
			String itemname, String category, double shoeSize, double price, String shoeType) {
		super();
		this.orderid = orderid;
		this.custid = custid;
		this.itemid = itemid;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.status = status;
		this.itemname = itemname;
		this.category = category;
		this.shoeSize = shoeSize;
		this.price = price;
		this.shoeType = shoeType;
	}
	
	public OrderResultBean() {
		
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getShoeSize() {
		return shoeSize;
	}

	public void setShoeSize(double shoeSize) {
		this.shoeSize = shoeSize;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getShoeType() {
		return shoeType;
	}

	public void setShoeType(String shoeType) {
		this.shoeType = shoeType;
	}
	
	
}
