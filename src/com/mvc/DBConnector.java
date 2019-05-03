package com.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
	private static final String url="jdbc:mysql://localhost:3306/MVCDB";
    private static final String DriverClass="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String password="1234567";
    
    static {
		try {
			Class.forName(DriverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
 
    public static Connection getConnection() throws Exception{
    	Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("ERROR: Connection Failed "+e.getMessage());
		}
    	connection.setAutoCommit(true);
		return connection;

   }

    public static void closeConnection(Connection con, Statement st, ResultSet rs) throws Exception{
            if(con!=null)
                    con.close();
            if(st!=null)
                    st.close();
            if(rs!=null)
                    rs.close();
    }

}


