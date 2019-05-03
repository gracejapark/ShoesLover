package com.mvc;

import java.io.Serializable;

public class ShoesBean implements Serializable{
	int itemid;
	String itemname;
	String category;
	double shoeSize;
	double price;
	String shoeType;
	
	public ShoesBean(int itemid,String itemname,String category,double shoeSize,double price, String shoeType) {
		this.itemid = itemid;
		this.itemname = itemname;
		this.category = category;
		this.shoeSize = shoeSize;
		this.price = price;
		this.shoeType = shoeType;
	}
	
	public ShoesBean() {
		this.itemid = 0;
		this.itemname = "";
		this.category = "";
		this.shoeSize = 0.0;
		this.price = 0.00;
		this.shoeType ="";
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
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
