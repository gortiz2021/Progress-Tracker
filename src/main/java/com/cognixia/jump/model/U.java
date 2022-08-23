package com.cognixia.jump.model;

// U model to be used later in UDAO class
// This model is based on the "user_tv_show" table from the 
// "progess_checker" database
//<<<<<<< HEAD
//=======
////class for junction table user_tv_show
//
//// U model to be used later in UDAO class
//// This model is based on the "user_tv_show" table from the 
//// "progess_checker" database
//
////class for junction table user_tv_show
//
//>>>>>>> d1bf63cfeac2abe1e503c967a0dc52a1bfe73bc7
public class U {

	// Variables are all based on the columns from the "user_tv_show" table
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

	// Overridden toString() method to display any object of this class
	@Override
	public String toString() {
		return "U [userId=" + userId + ", tvShowId=" + tvShowId + ", progress=" + progress + "]";
	}
	
}
