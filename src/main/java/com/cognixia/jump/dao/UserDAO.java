package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.cognixia.jump.ConnectionManager;
import com.cognixia.jump.jdbc.connection.ConnectionManagerWithProps;

public class UserDAO {
	private Connection conn = ConnectionManager.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = "";


	@Override
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

	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}
  
}
