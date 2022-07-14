package com.cognixia.jump.model;

public class U {

	private int userId;
	private int tvShowId;
	private int progress;

//	public U() {
//		this(-1, -1, "NA");
//	}
//	
	public U(int userId, int tvShowId, int progress) {
		super();
		this.userId = userId;
		this.tvShowId = tvShowId;
		this.progress = progress;
	}
	
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

	@Override
	public String toString() {
		return "U [userId=" + userId + ", tvShowId=" + tvShowId + ", progress=" + progress + "]";
	}
	
}
