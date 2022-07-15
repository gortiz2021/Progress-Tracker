package com.cognixia.jump.exceptions;


//Custom exception: Only to be used when accepting VARCHAR(255) character strings
//Only thrown when the length exceeds the max number of characters in a VARCHAR string
//this method is passed by the Menu.java class
public class InputOver255CharactersException extends Exception{

	private static final int stringLength = 255;
	
	public InputOver255CharactersException(int i) {
		//message that will be displayed if stack trace is printed
		super("String over 255 characters (VARCHAR max length). Attempted input is " + i
				+ " characters long when max accepted length is " + stringLength + " characters long.");
	}
	
}
