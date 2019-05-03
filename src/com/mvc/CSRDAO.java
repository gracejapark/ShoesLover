package com.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CSRDAO {
	Connection con = null;
	PreparedStatement pst;
	
public void addData(CSRBean csr)throws Exception{
		
		String insertQuery = "Insert into CSR (userName,password,firstname,lastname) values (?,?,?,?)";
		try {
			con = DBConnector.getConnection();
			pst = con.prepareStatement(insertQuery);
			
			pst.setString(1, csr.getUserName());
			pst.setString(2, csr.getPasswd());
			pst.setString(3, csr.getFirstname()); 
			pst.setString(4, csr.getLastname() );
			
			
		    pst.executeUpdate();
		    
        }catch(Exception e) {
	            e.printStackTrace();
        }finally {
	              DBConnector.closeConnection(con,pst,null);
        }
	}

public void deleteData(int employeeid)throws Exception{
	
	try {
		con = DBConnector.getConnection();
		
		String deleteQuery = "Delete from CSR where employeeId=? ";
		pst = con.prepareStatement(deleteQuery);
		pst.setInt(1, employeeid);
					
		pst.executeUpdate();
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		DBConnector.closeConnection(con,pst,null);
	}
}

public void listCSRData() throws Exception {
	try {
		String selectSQL = " SELECT* ";
		con = DBConnector.getConnection();
		PreparedStatement ps = null;
		ps = con.prepareStatement(selectSQL);
		ResultSet rs = null;
		rs = ps.executeQuery();
		
		while(rs.next()) {
			int employeeid = rs.getInt("CSR.employeeId");
			String userName = rs.getString("CSR.userName");
			String passwd = rs.getString("CSR.password");
			String firstname = rs.getString("CSR.firstname");
			String lastname = rs.getString("CSR.lastname");
		
			System.out.println( employeeid+ " " + userName + " " + passwd + " " 
			+ firstname + "" + lastname);
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


public void SearchCustomer(int employeeid, String username) throws Exception {
	try {
		String selectSQL = " SELECT employeeId,userName,password,firstname,lastname FROM CSR WHERE employeeId = ?,userName = ?";
		con = DBConnector.getConnection();
		PreparedStatement ps = null;
		ps = con.prepareStatement(selectSQL);
		ps.setInt(1, employeeid);
		ps.setString(2, username);
		ResultSet rs = null;
		rs = ps.executeQuery();
		
		while(rs.next()) {
			String passwd = rs.getString("CSR.password");
			String firstname = rs.getString("CSR.firstname");
			String lastname = rs.getString("CSR.lastname");
		
			System.out.println( employeeid+ " " + username + " " + passwd + " " 
			+ firstname + "" + lastname);
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
