package com.mvc;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class OrdersBean implements Serializable{
	int orderid;
	int custid;
	int itemid;
	Timestamp orderDate;
	int quantity;
	String status;

	public OrdersBean(int orderid, int custid,int itemid,Timestamp orderDate,int quantity,String status ){
		this.orderid = itemid;
		this.custid = custid;
		this.itemid = itemid;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.status = status;
	}
	
	public OrdersBean(){
		
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
	
	
}
