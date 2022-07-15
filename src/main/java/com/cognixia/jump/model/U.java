package com.cognixia.jump.model;

// U model to be used later in UDAO class
// This model is based on the "user_tv_show" table from the 
// "progess_checker" database
//class for junction table user_tv_show
public class U {

	// Vairables are all based on the colums from the "user_tv_show" table
	private int userId;
	private int tvShowId;
	private int progress;

	// Two default constructors that are to create new objects of this class
	public U() {
		this(-1, -1, -1);
	}
	
	public U(int userId, int tvShowId, int progress) {
		super();
		this.userId = userId;
		this.tvShowId = tvShowId;
		this.progress = progress;
	}
	
	// A list of auto-generated getter and setter functions for every variable 
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTvShowId() {
		return tvShowId;
	}

	public void setTvShowId(int tvShowId) {
		this.tvShowId = tvShowId;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	// Overriden toString() method to display any object of this class
	@Override
	public String toString() {
		return "U [userId=" + userId + ", tvShowId=" + tvShowId + ", progress=" + progress + "]";
	}
	
}
