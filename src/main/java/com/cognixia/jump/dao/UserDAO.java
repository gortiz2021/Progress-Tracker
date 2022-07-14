package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cognixia.jump.Menu;
import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.exceptions.UserAlreadyExistsException;
import com.cognixia.jump.model.User;

public class UserDAO {
	private Connection conn = ConnectionManager.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = "";
	private String username;
	private String password;

	public User findbyId(int id) {
		try {
			query = "select * from user where user_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
//	@Override
//	public List<User> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean create(User entity) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean update(User entity) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean deleteById(int id) {
//		// TODO Auto-generated method stub
//		return false;
//	}


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
