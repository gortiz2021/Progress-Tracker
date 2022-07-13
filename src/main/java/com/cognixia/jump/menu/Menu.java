package com.cognixia.jump.menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cognixia.jump.ConnectionManager;
import com.cognixia.jump.exceptions.InputOver255CharactersException;

public class Menu {
	
	private static final int signed_in_options = 4;
	private static final int log_in_options =2;
	
	private static Connection conn = ConnectionManager.getConnection();
	
	public static void main(String[] args) {
		
		PreparedStatement pstmt = null;
		ResultSet rs1 = null;
		String query = "";
		Scanner scan = new Scanner(System.in);
	
		
		boolean cond = true;
		System.out.println();
		System.out.println("==========================================================");
		System.out.println("=            Please chooose an option?                   =");
		System.out.println("==========================================================");
		System.out.println();

		try {
			
			while (cond) {
				
				LoginOptions();
				int response = getResponse(log_in_options, scan);
	
				switch (response) {
				
				case 1:
					
					scan.nextLine();
					String getUsername = "";
					String getPassword = "";
					
					try {
						
						System.out.println("Enter username: ");
						getUsername = scan.nextLine();
						
						if (getUsername.length() > 255)
							throw new InputOver255CharactersException(getUsername.length());
						
						System.out.println("Enter password: ");
						scan.nextLine();
						getPassword = scan.nextLine();
						
						if (getPassword.length() > 255)
							throw new InputOver255CharactersException(getPassword.length());
						
					} catch (InputOver255CharactersException e){
						
						System.out.println("Input over max length (255 characters)");
						
					}
					try {
						
						query = "select * from user where username = username";
						PreparedStatement pstmt1 = conn.prepareStatement("select username, password from `user` where username = ?;");
						pstmt1.setString(1, getUsername);
						rs1 = pstmt1.executeQuery(query);
						
						while(rs1.next()) {
							
						String user_name = rs1.getString("username");
						String pass_word = rs1.getString("password");
						
						if (getUsername == user_name && getPassword == pass_word) {
							
							System.out.println("Log In Successful");
							SignedInlistOptions();
							
						}
						
						else {
							
								System.out.println("Log in not successful! Please try again!");
								LoginOptions();
								
						}
						
						break;
						
						}
						
					}
					
						
						
					catch (Exception e) {
						e.printStackTrace();
					}
					
				case 2:
					break;
				case 3:
					break;
	
				}
	
			}
		
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				rs1.close();
				pstmt.close();
				conn.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
			
		}

	}

	
	private static void LoginOptions() {
		
		System.out.println("========================OPTIONS===========================");
		System.out.println("==========================================================");
		System.out.println("Please select an option: ");
		System.out.println("#1: Log In");
		System.out.println("#2: Exit System");
		
	}
	
	
	
//console menu	
	private static void SignedInlistOptions() {
		
		System.out.println("========================OPTIONS===========================");
		System.out.println("==========================================================");
		System.out.println("Please select an option: ");
		//view progess
		System.out.println("#1: Replace with option 1");
		//update tracker
		System.out.println("#2: Replace with option 2");
		//view completed
		System.out.println("#3: Replace with option 3");
		System.out.println("==========================================================");
		System.out.println("==========================================================");
		System.out.println();
		

	}

	// gets menu response
	private static int getResponse(int range, Scanner scan) {
		
		boolean cond = true;
		int optHolder = -1;
		System.out.println("Enter your choice by number: ");
		
		while (cond) {
			
			try {
				
				optHolder = scan.nextInt();
				if (optHolder < 1 || optHolder > range)
					System.out.println("You must select a number between 1 and " + range + "!");
				else
					cond = false;

			} catch (InputMismatchException e) {
				
				System.out.println("Please enter a number!");
				scan.next();

			}
		}
		
		return optHolder;

	}

}
