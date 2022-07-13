package com.cognixia.jump.exceptions;

public class InputOver255CharactersException extends Exception{

	private static final int stringLength = 255;
	
	public InputOver255CharactersException(String input) {
		super("String over 255 characters (VARCHAR max length). Attempted input is " + input
				+ " characters long when max accepted length is " + stringLength + " characters long.");
	}
	
}
