package com.cognixia.jump.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.exceptions.UserAlreadyExistsException;
import com.cognixia.jump.Menu;

public class User{
	Connection conn = ConnectionManager.getConnection();

	private int user_id;
	private String username;
	private String password;
	
	public User() {
		this(-1, "N/A", "N/A");
	}
	
	public User(int user_id, String username, String password) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		
	}

	public long getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
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
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + "]";
	}
	public void addUser() {
		String query = "insert into user (username, password) values (?, ?)";
		String check = "select * from user where username = ?";
		System.out.println("CREATE A USER:");
		System.out.println("please enter your username");
		username = Menu.scan.nextLine();
		System.out.println("Please enter your password");
		password = Menu.scan.nextLine();
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			PreparedStatement pstmt2 = conn.prepareStatement(check);
			pstmt2.setString(1, username);
//			pstmt2.setString(2, password);
//			int i = pstmt2.executeUpdate();
			ResultSet rs = pstmt2.executeQuery();
			
//			System.out.println(rs);
			if (rs.next() == false) {
				int i = pstmt.executeUpdate();
				System.out.println("user created with username: " + username);				
			}
			else {
				throw new UserAlreadyExistsException("user already exists!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (UserAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
