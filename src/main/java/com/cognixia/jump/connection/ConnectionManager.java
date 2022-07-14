package com.cognixia.jump.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	// Interface + sql Engine + sql server ip address (localhost is an alias) + port number + db name
	private static final String URL = "jdbc:mysql://localhost:3306/progress_tracker";
	
	//ENTER YOUR OWN USERNAME AND PASSWORD TO YOUR MYSQL SERVER!!!!!!

	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected to " + URL);
			
		} catch(SQLException e) {
			System.out.println("Could not connect, see message: " + e.getMessage());
		}
		
		return conn;
		
	}

	public static void closeConnection(Connection conn) {
		
		try {
			conn.close();
			System.out.println("Connection closed.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
	
}