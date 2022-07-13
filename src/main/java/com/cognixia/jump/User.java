package com.cognixia.jump;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//user class to create a new user.
//driver class to run this class is as follows:
/*
 * public class Driver {
	public final static Scanner kb = new Scanner(System.in);
	public static void main(String[] args) {
		User user = new User();
		user.addUser();
	}
}
 */
public class User {
	Connection conn = ConnectionManager.getConnection();
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	public void addUser() {
		String query = "insert into user (username, password) values (?, ?)";
		System.out.println("CREATE A USER:");
		System.out.println("please enter your username");
		username = Driver.kb.nextLine();
		System.out.println("Please enter your password");
		password = Driver.kb.nextLine();
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			int i = pstmt.executeUpdate();
			System.out.println("user created with username: " + username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		System.out.println("user created with username= " + username + " and password= " + password);
	}
}