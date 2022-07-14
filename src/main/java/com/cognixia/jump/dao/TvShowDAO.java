package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.TvShow;

public class TvShowDAO {
	
	// List functionality we want to have to get data from our DB to our Models.


	private Connection conn = ConnectionManager.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = "";
	
	public TvShow getTvShow (int id){
		
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
	
	
	//returns all tv shows from the database as a list
	public  List<TvShow> getAllTvShow() {
		
		List<TvShow> tvShowList = new LinkedList<>();
		
		try {
			
			//SELECT ALL TV SHOWS FROM TV_SHOW
			query = "select * from tv_show";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			//loop until there are no more shows to go through
			while(rs.next()) {
				
				TvShow show = new TvShow();
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
				tvShowList.add(show);
				
			}
			
			return tvShowList;
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	
}
