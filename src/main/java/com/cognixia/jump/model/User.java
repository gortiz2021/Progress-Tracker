package com.cognixia.jump.model;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersion = 1L;
	
	private long user_id;
	private String username;
	private String password;
	
	public User() {
		this(-1L, "N/A", "N/A");
	}
	
	public User(long user_id, String username, String password) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		
	}

	public long getUser_id() {
		return user_id;
	}
	
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + "]";
	}
	
	
	

}
