package edu.northeastern.cs5200;

import java.sql.DriverManager;
import java.sql.SQLException;


public class Connection {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://cs5200-fall2018-a2-amritanair.cswbuuhydfxj.us-east-2.rds.amazonaws.com/cs5200_fall2018_A3_amritanair";
	private static final String USER = "amritanair";
	private static final String PASSWORD = "password";
	static java.sql.Connection conn = null;
	public static java.sql.Connection getConnection()  {
		if(conn != null) return conn;
    	try {
			Class.forName(DRIVER);
			conn= DriverManager.getConnection(URL, USER, PASSWORD);
			return conn;	
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConnection(java.sql.Connection conn2) {
   	 try {
   		 conn2.close();
   	 } catch (SQLException e) {
   		 // TODO Auto-generated catch block
   		 e.printStackTrace();
   	 }
	}
}
