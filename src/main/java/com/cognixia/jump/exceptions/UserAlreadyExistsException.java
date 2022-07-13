package com.cognixia.jump.exceptions;

public class UserAlreadyExistsException extends Exception{
	public UserAlreadyExistsException(String message) {
		super(message);
	}
}