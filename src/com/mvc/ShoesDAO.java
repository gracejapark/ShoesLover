package com.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoesDAO {
	Connection con = null;
	PreparedStatement pst;
	
public void addData(ShoesBean shoes)throws Exception{
		
		String insertQuery = "Insert into Shoes (itemName,category,shoeSize,price,shoeType) values (?,?,?,?,?)";
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(insertQuery);
			
			pst.setString(1, shoes.getItemname());
			pst.setString(2, shoes.getCategory());
			pst.setDouble(3, shoes.getShoeSize()); 
			pst.setDouble(4, shoes.getPrice());
			pst.setString(5, shoes.getShoeType());
			
		    pst.executeUpdate();
		    
        }catch(Exception e) {
	            e.printStackTrace();
        }finally {
	              DBConnector.closeConnection(con,pst,null);
        }
	}
	
	public void updateData(ShoesBean shoes)throws Exception{
				
		String updateQuery = "Update Shoes set itemid=?,itemName=?, category=?,shoeSize=?,price=?, shoetype=? where itemName=? and category=? and shoeSize=? and price=? and shoeType";
				
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(updateQuery);
			
			pst.setInt(1, shoes.getItemid());
			pst.setString(2, shoes.getItemname());
			pst.setString(3, shoes.getCategory());
			pst.setDouble(4, shoes.getShoeSize()); 
			pst.setDouble(5, shoes.getPrice());
			pst.setString(6, shoes.getShoeType());	
			pst.executeUpdate();	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnector.closeConnection(con,pst,null);
		}
	}
	
	public void deleteData(int itemid)throws Exception{
		
		try {
			con = DBConnector.getConnection();
			
			String deleteQuery = "Delete from Shoes where itemId=? ";
			pst = con.prepareStatement(deleteQuery);
			pst.setInt(1, itemid);
						
			pst.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnector.closeConnection(con,pst,null);
		}
	}
	
	public void listShoesData() throws Exception {
		try {
			String selectSQL = " SELECT* FROM Shoes WHERE itemId = ? and itemName = ? and category = ? and shoeSize = ? and price= ? and shoeType = ?";
			con = DBConnector.getConnection();
			PreparedStatement ps = null;
			ps = con.prepareStatement(selectSQL);
			ResultSet rs = null;
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int itemid = rs.getInt("Shoes.itemId");
				String itemname = rs.getString("Shoes.itemName");
				String category = rs.getString("Shoes.category");
				double shoeSize = rs.getDouble("Shoes.shoeSize"); 
				double price = rs.getDouble("Shoes.price");
				String shoeType = rs.getString("Shoes.shoeType");
				System.out.println( itemid+ " " + itemname + " " + category + " " + shoeSize + " " +price + " " + shoeType); 
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConnection(con,pst,null);
		}
	}
	// select men, women or kids shoes
	public List<ShoesBean> listShoesData(String shoeType) throws Exception {
		
			List<ShoesBean> shoes = new ArrayList<ShoesBean>();
		
			try {  
				
			String selectSQL = " SELECT itemId, itemName, category, shoeSize, price, shoeType FROM Shoes WHERE shoeType = ?";
			con = DBConnector.getConnection();
			PreparedStatement ps = null;
			ps = con.prepareStatement(selectSQL);
			ps.setString(1, shoeType);
			ResultSet rs = null;
			rs = ps.executeQuery();
			
			while(rs.next()) { 
				int itemid = rs.getInt("Shoes.itemId");
				String itemname = rs.getString("Shoes.itemName");
				String category = rs.getString("Shoes.category");
				double shoeSize = rs.getDouble("Shoes.shoeSize"); 
				double price = rs.getDouble("Shoes.price");
				
				ShoesBean shoe = new ShoesBean();
				shoe.setItemid(itemid);
				shoe.setItemname(itemname);
				shoe.setCategory(category);
				shoe.setShoeSize(shoeSize);
				shoe.setPrice(price);
			
				shoes.add(shoe);
				
//				System.out.println( itemid+ " " + itemname + " " + category + " " 
//						+ shoeSize + "" + price+ " " + shoeType);
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConnection(con,pst,null);
		}
		return shoes;
	}
	
	public void SearchCustomer(int itemid, String itemname,String category, double shoeSize, String shoeType) throws Exception {
		try {
			String selectSQL = " SELECT itemId,itemName,category,shoeSize,price FROM Shoes WHERE itemId = ? and itemName = ? and category =? and shoeSize =? and shoeType =?";
			con = DBConnector.getConnection();
			PreparedStatement ps = null;
			ps = con.prepareStatement(selectSQL);
			ps.setInt(1, itemid);
			ps.setString(2, itemname);
			ps.setString(3, category);
			ps.setDouble(4, shoeSize);
			ResultSet rs = null;
			rs = ps.executeQuery();
			
			while(rs.next()) {
				double price = rs.getDouble("Shoes.price");
				
			
				System.out.println( itemid+ " " + itemname + " " + category + " " + shoeSize + "" + price + "" + shoeType);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConnection(con,pst,null);
		}
	}
}
