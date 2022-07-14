package com.cognixia.jump.dao;

import java.io.Serializable;
import java.util.List;

import com.cognixia.jump.model.User;

public interface UDAO<U extends Serializable> {
	//get one by id
	U findbyId(int id);
	
	//get all
	List<U> findAll();
	
	//add to db
	public void addUser();
	//update to db
	boolean update(U entity);
	//delete by id
	boolean deleteById(int id);

	boolean create(User entity);

	
	
	
	
	
	

	
}

