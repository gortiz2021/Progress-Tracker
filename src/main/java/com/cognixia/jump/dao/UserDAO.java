package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cognixia.jump.jdbc.connection.ConnectionManagerWithProps;

public class UserDAO {
	private Connection conn = ConnectionManagerWithProps.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = "";

	
}
