package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.TvShow;

public class TvShowDAO {
	
	// List functionality we want to have to get data from our DB to our Models.
	private Connection conn = ConnectionManager.getConnection();
	
	public TvShow getTvShow (int id){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		TvShow show = null;
		
		try {
			query = "select * from tv_show where tv_show_id = ?;";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				show.setId(rs.getInt(1));
				show.setName(rs.getString(2));
				show.setLeadingActor(rs.getString(3));
				show.setDirector(rs.getString(4));
				show.setNumOfSeasons(rs.getInt(5));
				show.setNumOfEpisodes(rs.getInt(6));
				show.setGenre(rs.getString(7));
				show.setAudienceScore(rs.getInt(8));
				show.setRating(rs.getString(9));
				show.setFirstEpisodeName(rs.getString(10));
				show.setStatus(rs.getString(11));
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
			
		return show;
	}
	
	public  List<TvShow> getAllTvShow() {
		
		return null;
	}
	
}
