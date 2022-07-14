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
	U u = null;
	
	
	//get one by id
//	U findbyId(int id);
//	
//	//get all
//	List<U> findAll();
//	
//	//add to db
//	public void addUser();
//	//update to db
//	boolean update(U entity);
//	//delete by id
//	boolean deleteById(int id);
//
//	boolean create(User entity);

}
	

