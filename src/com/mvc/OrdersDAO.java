package com.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO {
	Connection con = null;
	PreparedStatement pst;
	
	public boolean addData(OrdersBean orders)throws Exception{
		String insertQuery = "Insert into Orders (customerId,itemId,quantity,status) values (?,?,?,?)";
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(insertQuery);
			
			pst.setInt(1, orders.getCustid());
			pst.setInt(2, orders.getItemid());
			pst.setInt(3, orders.getQuantity());
			pst.setString(4, orders.getStatus());
			
		    pst.executeUpdate();
	    }catch(Exception e) {
	        e.printStackTrace();
	        return false;
	    }finally {
	      DBConnector.closeConnection(con,pst,null);
	    }
		return true;
	}
	
	public void updateData(OrdersBean orders)throws Exception{
		
		String updateQuery = "Update Orders set orderId=?,customerId=?, itemId=?,orderDate=?,quantity=?, status=? where orderId=? and customerId=? and itemId=? and orderDate=? and quantity=? and status=? ";
				
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(updateQuery);
			
			pst.setInt(1, orders.getOrderid());
			pst.setInt(2, orders.getCustid());
			pst.setInt(3, orders.getItemid());
			pst.setTimestamp(4, orders.getOrderDate());
			pst.setInt(5, orders.getQuantity());
			pst.setString(6, orders.getStatus());	
			pst.executeUpdate();	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnector.closeConnection(con,pst,null);
		}
	}
	
	public void deleteData(int orderid)throws Exception{
		
		try {
			con = DBConnector.getConnection();
			
			String deleteQuery = "Delete from Orders where orderId=? ";
			pst = con.prepareStatement(deleteQuery);
			pst.setInt(1, orderid);
						
			pst.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnector.closeConnection(con,pst,null);
		}
	}

	public void deleteOrders(String[] orderIds)throws Exception{
		
		try {
			con = DBConnector.getConnection();
			con.setAutoCommit(true);
			String deleteQuery = "DELETE FROM Orders WHERE orderId = ? ";
			pst = con.prepareStatement(deleteQuery);
			for(String orderId : orderIds) {
				pst.setInt(1, Integer.valueOf(orderId));
				pst.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnector.closeConnection(con,pst,null);
		}
	}

	public void updateOrderStatus(String[] orderIds, String orderStatus)throws Exception {
		
		try {
			con = DBConnector.getConnection();
			con.setAutoCommit(true);
			String deleteQuery = "UPDATE orders SET status = ? WHERE orderId = ? ";
			pst = con.prepareStatement(deleteQuery);
			for(String orderId : orderIds) {
				pst.setString(1, orderStatus);
				pst.setInt(2, Integer.valueOf(orderId));
				pst.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnector.closeConnection(con,pst,null);
		}
	}
	
	public List<OrderResultBean> listOrderData(int customerId) throws Exception {
		List<OrderResultBean> orders = new ArrayList<>();
		
		try {
			String selectSQL = "SELECT o.orderId, o.customerId, o.itemId, o.orderDate, o.quantity, o.status, s.itemName, s.category, s.shoeSize, s.price, s.shoeType "
					+ " FROM orders o, shoes s"
					+ " WHERE o.itemId = s.itemId AND o.customerId = ?";
			con = DBConnector.getConnection();
			PreparedStatement ps = null;
			ps = con.prepareStatement(selectSQL);
			ps.setInt(1,  customerId);
			
			ResultSet rs = null;
			rs = ps.executeQuery();
			
			while(rs.next()) {
				// o.orderId, o.customerId, o.itemId, o.orderDate, o.quantity, o.status, s.itemName, s.category, s.shoeSize, s.price, s.shoeType
				// public OrderResultBean(int orderid, int custid, int itemid, Timestamp orderDate, int quantity, String status,
				//		String itemname, String category, double shoeSize, double price, String shoeType) {
				
				OrderResultBean orderInfo = new OrderResultBean(
							rs.getInt("o.orderId"),
							rs.getInt("o.customerId"),
							rs.getInt("o.itemId"),
							rs.getTimestamp("o.orderDate"),
							rs.getInt("o.quantity"),
							rs.getString("o.status"),
							rs.getString("s.itemName"),
							rs.getString("s.category"),
							rs.getDouble("s.shoeSize"),
							rs.getDouble("s.price"),
							rs.getString("s.shoeType")
						);
				
				orders.add(orderInfo);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConnection(con,pst,null);
		}
		
		return orders;
	}
	
	public List<OrderResultBean> listOrderData(int customerId, String status) throws Exception {
		List<OrderResultBean> orders = new ArrayList<>();
		
		System.out.println(customerId);
		System.out.println(status);
		
		try {
			String selectSQL = "SELECT o.orderId, o.customerId, o.itemId, o.orderDate, o.quantity, o.status, s.itemName, s.category, s.shoeSize, s.price, s.shoeType "
					+ " FROM orders o, shoes s"
					+ " WHERE o.itemId = s.itemId AND o.customerId = ? AND o.status = ?";
			con = DBConnector.getConnection();
			PreparedStatement ps = null;
			ps = con.prepareStatement(selectSQL);
			ps.setInt(1,  customerId);
			ps.setString(2, status);
			
			ResultSet rs = null;
			rs = ps.executeQuery();
			
			while(rs.next()) {
				OrderResultBean orderInfo = new OrderResultBean(
							rs.getInt("o.orderId"),
							rs.getInt("o.customerId"),
							rs.getInt("o.itemId"),
							rs.getTimestamp("o.orderDate"),
							rs.getInt("o.quantity"),
							rs.getString("o.status"),
							rs.getString("s.itemName"),
							rs.getString("s.category"),
							rs.getDouble("s.shoeSize"),
							rs.getDouble("s.price"),
							rs.getString("s.shoeType")
						);
				
				orders.add(orderInfo);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConnection(con,pst,null);
		}
		
		return orders;
	}
}
