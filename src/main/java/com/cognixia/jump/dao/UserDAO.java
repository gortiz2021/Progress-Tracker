package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cognixia.jump.Menu;
import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.exceptions.UserAlreadyExistsException;
import com.cognixia.jump.model.User;
/**
 * User Data Access Object Class. The class contains certain methods pertaining to the user.
 * @authors Jacob Laws, Michelle Lovse, Gabriel Ortiz, Toju Mikie
 *
 */
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

	/*
	 * Method to add a user to the database. The user table will populate with user information, and then the user_tv_show table
	 * will also populate with id information related to both user and tv shows.
	 */
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
		String query3 = "select count(*) from tv_show";
		String getUserIDStr = "select user_id from user where username = ?";
		int numTVShows = 0;
		int getUserIDNum = 0;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(query3);
			while(rs.next()) {
//				System.out.println(rs.getInt(1));
				numTVShows = rs.getInt(1);
			}
			PreparedStatement pstmt4 = conn.prepareStatement(getUserIDStr);
			pstmt4.setString(1, username);
			ResultSet rs2 = pstmt4.executeQuery();
			while(rs2.next()) {
				getUserIDNum = rs2.getInt("user_id");
//				System.out.println("user id!!!! " + getUserIDNum);				
			}
			
			
			String query4 = "insert into user_tv_show values(?, ?, ?)";
//			int id = getUserIDNum;
			int showID = 1;
			int watched = 0;
			for(; showID <= numTVShows; showID++) {
				PreparedStatement pstmt3 = conn.prepareStatement(query4);
				pstmt3.setInt(1, getUserIDNum);
				pstmt3.setInt(2, showID);
				pstmt3.setInt(3, watched);
				pstmt3.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
  
}
