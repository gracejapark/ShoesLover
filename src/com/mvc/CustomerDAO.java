package com.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class CustomerDAO {
	Connection con = null;
	PreparedStatement pst;
	
	public void addData(CustomerBean customer)throws Exception{
		
		String insertQuery = "Insert into Customers (userName,password,firstname,lastname,address,city,postalCode) values (?,?,?,?,?,?,?)";
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(insertQuery);
			

			pst.setString(1, customer.getUsrname());
			pst.setString(2, customer.getPasswd());
			pst.setString(3, customer.getFirstname()); 
			pst.setString(4, customer.getLastname() );
			pst.setString(5, customer.getAddress() );
			pst.setString(6, customer.getCity() ); 
			pst.setString(7, customer.getPostalcd());
			
		    pst.executeUpdate();
		    
        }catch(Exception e) {
	            e.printStackTrace();
        }finally {
	              DBConnector.closeConnection(con,pst,null);
        }
	}
	
	public void updateData(CustomerBean customer)throws Exception{
				
		String updateQuery = "Update Customers set userName=?, password=?,firstname=?,lastname=?,address=?,city=?,postalCode=? where userName=? and password=? and firstname=? and lastname=? and address=? and city=? and postalCode=?";
				
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(updateQuery);
			
			pst.setString(1, customer.getUsrname());
			pst.setString(2, customer.getPasswd());
			pst.setString(3, customer.getFirstname()); 
			pst.setString(4, customer.getLastname() );
			pst.setString(5, customer.getAddress() );
			pst.setString(6, customer.getCity() ); 
			pst.setString(7, customer.getPostalcd());
				
			pst.executeUpdate();	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnector.closeConnection(con,pst,null);
		}
	}
	
	public void deleteData(int custid)throws Exception{
		
		try {
			con = DBConnector.getConnection();
			
			String deleteQuery = "Delete from Customers where customerId=? ";
			pst = con.prepareStatement(deleteQuery);
			pst.setInt(1, custid);
						
			pst.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnector.closeConnection(con,pst,null);
		}
	}
	
	public void listCustomerData() throws Exception {
		try {
			String selectSQL = " SELECT* ";
			con = DBConnector.getConnection();
			PreparedStatement ps = null;
			ps = con.prepareStatement(selectSQL);
			ResultSet rs = null;
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int custid = rs.getInt("Customers.customerId");
				String usrname = rs.getString("Customers.userName");
				String passwd = rs.getString("Customers.password");
				String firstname = rs.getString("Customers.firstname");
				String lastname = rs.getString("Customers.lastname");
				String address = rs.getString("Customers.address");
				String city = rs.getString("Customers.city");
				String postalcd = rs.getString("Customers.postalCode");
			
				System.out.println( custid+ " " + usrname + " " + passwd + " " 
				+ firstname + "" + lastname+ " " + address+ " " + city+ " " + postalcd);
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
	
	
	public CustomerBean search(String usrname) throws Exception {
		CustomerBean custbean = new CustomerBean();
		try {
			String selectSQL = " SELECT customerId,userName,password,firstname,lastname,address,city,postalCode FROM Customers WHERE userName = ?";
			con = DBConnector.getConnection();
			PreparedStatement ps = null;
			ps = con.prepareStatement(selectSQL);
			ps.setString(1, usrname);
			ResultSet rs = null;
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int custid = rs.getInt("Customers.customerId");
				String passwd = rs.getString("Customers.password");
				String firstname = rs.getString("Customers.firstname");
				String lastname = rs.getString("Customers.lastname");
				String address = rs.getString("Customers.address");
				String city = rs.getString("Customers.city");
				String postalcd = rs.getString("Customers.postalCode");
				
				custbean.setCustid(custid);
				custbean.setPasswd(passwd);
				custbean.setFirstname(firstname);
				custbean.setLastname(lastname);
				custbean.setAddress(address);
				custbean.setCity(city);
				custbean.setPostalcd(postalcd);
				
				
			//	System.out.println( custid+ " " + usrname + " " + passwd + " " 
			//	+ firstname + "" + lastname+ " " + address+ " " + city+ " " + postalcd);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConnection(con,pst,null);
		}
		
		return custbean;
	}
	public void SearchCustomer(int custid, String usrname) throws Exception {
		try {
			String selectSQL = " SELECT customerId,userName,password,firstname,lastname,address,city,postalCode FROM Customers WHERE customerId = ?,userName = ?";
			con = DBConnector.getConnection();
			PreparedStatement ps = null;
			ps = con.prepareStatement(selectSQL);
			ps.setInt(1, custid);
			ps.setString(2, usrname);
			ResultSet rs = null;
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String passwd = rs.getString("Customers.password");
				String firstname = rs.getString("Customers.firstname");
				String lastname = rs.getString("Customers.lastname");
				String address = rs.getString("Customers.address");
				String city = rs.getString("Customers.city");
				String postalcd = rs.getString("Customers.postalCode");
			
				System.out.println( custid+ " " + usrname + " " + passwd + " " 
				+ firstname + "" + lastname+ " " + address+ " " + city+ " " + postalcd);
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
	public boolean validateUser(String usrname , String passwd ) throws Exception {
		try {
			String selectSQL = " SELECT customerId, userName, password, firstname, lastname, address, city, postalCode FROM Customers WHERE userName = ?  AND password = ? ";
			con = DBConnector.getConnection();
			PreparedStatement ps = null;
			ps = con.prepareStatement(selectSQL);
			ps.setString(1, usrname);
			ps.setString(2, passwd);
			ResultSet rs = null;
			rs = ps.executeQuery();
			
			if (rs.next()) {
				
				return true;	
			}	
			else {
				
				return false;	
			}		
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConnection(con,pst,null);
		}
		return false;
	}
}
