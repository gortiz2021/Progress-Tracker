package com.cognixia.jump.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.U;

public class UDAO {
	
	private Connection conn = ConnectionManager.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = "";	
	
	//read by user and show id
	public U readProgressOfTvShow(int userId, int showId) {
		U u = null;
		
		try {
			query = "select * from user_tv_show where user_id = ? and show_id = ?;";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, showId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				u.setProgress(rs.getInt(3));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	//update to db
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
				u.setProgress(rs.getInt(3));
				u.setUserId(rs.getInt(1));
				u.setTvShowId(rs.getInt(2));
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}

}
	

