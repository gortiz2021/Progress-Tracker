package com.cognixia.jump.exceptions;
/**
 * Custom Exception to give a message that the user already exists. The message is passed by the UserDAO.addUser() method.
 * @authors Jacob Laws, Michelle Lovse, Gabriel Ortiz, Toju Mikie
 *
 */
public class UserAlreadyExistsException extends Exception{
	public UserAlreadyExistsException(String message) {
		super(message);
	}
}