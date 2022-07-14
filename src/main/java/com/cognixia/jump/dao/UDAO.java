package com.cognixia.jump.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.U;

public class UDAO {
	
	private Connection conn = ConnectionManager.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = "";	
	
	//	//update to db
	public U updateProgressOfTvShow(int progress, int userId, int showId) {
		
		U u = null;
		
		try {
			
			query = "update user_tv_show\r\n"
					+ "set progress = ?\r\n"
					+ "where user_id = ? and show_id = ?;";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, progress);
			pstmt.setInt(2, userId);
			pstmt.setInt(3, showId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				u.setProgress(rs.getInt(1));
				u.setUserId(rs.getInt(2));
				u.setTvShowId(rs.getInt(3));
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return u;
		
	}
	//get one by id
//	U findbyId(int id);
//	
//	//get all
//	List<U> findAll();
//	
//	//add to db
//	public void addUser();

//	//delete by id
//	boolean deleteById(int id);
//
//	boolean create(User entity);

}
	

