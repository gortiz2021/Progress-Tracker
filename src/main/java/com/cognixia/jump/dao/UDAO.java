package com.cognixia.jump.dao;

import java.io.Serializable;
import java.util.List;

public interface UDAO<U extends Serializable> {
	//get one by id
	U findbyId(long id);
	
	//get all
	List<U> findAll();
	
	//add to db
	boolean create(U entity);
	//update to db
	boolean update(U entity);
	//delete by id
	boolean deleteById(long id);
	
	
	
	
	

	
}
