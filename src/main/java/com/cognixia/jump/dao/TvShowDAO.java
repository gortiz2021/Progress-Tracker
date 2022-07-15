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

	// Initialize variables outside of methods to avoid redundant code 
	private Connection conn = ConnectionManager.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = "";
	
	// Will create a TvShow object and takes in a id
	// will return a single tv show based on the inputed 
	// tv show id
	public TvShow getTvShow (int id){
		
		TvShow show = null;
	
		try {
			// SQL query that is saved as a prepared statement 
			query = "select * from tv_show where tv_show_id = ?;";
			
			pstmt = conn.prepareStatement(query);
			// set the parameter index (what "?" you are selecting), then
			// the value you want to input in that place
			pstmt.setInt(1, id);

			// save the prepared statement inside a result set
			rs = pstmt.executeQuery();
			
			// goes through the result set and stores the information taken from the 
			// database which is then saved inside a TvShow object named "show"
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
		// avoid empty catch blocks
		catch (Exception e){
			e.printStackTrace();
		}
			
		// return the object that stored all the info
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
				
				//initialize a new show object
				//then use setters to construct the object
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
				//then add it to the list
				tvShowList.add(show);
				
			}
			
			return tvShowList;
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	
}
