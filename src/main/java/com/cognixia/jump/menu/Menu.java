package com.cognixia.jump.menu;

import static java.lang.System.exit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cognixia.jump.ConnectionManager;
import com.cognixia.jump.dao.UserDAO;
import com.cognixia.jump.exceptions.InputOver255CharactersException;
import com.cognixia.jump.model.User;

public class Menu {
	public final static Scanner scan = new Scanner(System.in);

	static UserDAO userDAO = new UserDAO();

	private static final int signed_in_options = 4;
	private static final int log_in_options = 3;
	private boolean exit;

	private static Connection conn = ConnectionManager.getConnection();

	public static void main(String[] args) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
//		Scanner scan = new Scanner(System.in);
		User user = new User();

		boolean loginCond = true;
		System.out.println();
		System.out.println("==========================================================");
		System.out.println("=            Please chooose an option?                   =");
		System.out.println("==========================================================");
		System.out.println();

		try {

			while (loginCond) {

				LoginOptions();
				int response = getResponse(log_in_options, scan);

				switch (response) {

				case 1:

//					scan.nextLine();
					String getUsername = "";
					String getPassword = "";
					Integer user_id = 0;
					try {

						System.out.println("Enter username: ");
						getUsername = scan.nextLine();

						if (getUsername.length() > 255)
							throw new InputOver255CharactersException(getUsername.length());

						System.out.println("Enter password: ");
						getPassword = scan.nextLine();

						if (getPassword.length() > 255)
							throw new InputOver255CharactersException(getPassword.length());

					} catch (InputOver255CharactersException e) {

						System.out.println("Input over max length (255 characters)");

					}

					pstmt = conn.prepareStatement("select * from user where username = ? and password = ?");

					pstmt.setString(1, getUsername);
					pstmt.setString(2, getPassword);

					rs = pstmt.executeQuery();

					if (!rs.next()) {
						System.out.println("Incorrect username or password -- Please try again!\n");
						getUsername = "";
						continue;
					}
					else {
						System.out.println("Login Successful!");
					
					int id = rs.getInt("user_id");
					System.out.println(id);
					SignedInlistOptions();
					
					}
					rs.close();
					pstmt.close();
					loginCond = false;
					break;
					

				case 2:
					exit(0);
					break;
				case 3:
					user.addUser();
					break;	
				
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				rs.close();
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
		boolean ptcond = true;
		
		System.out.println("====================PROGRESS TRACKER======================");
		System.out.println("==========================================================");
		System.out.println("Please select an option: ");
		// view progess
		System.out.println("#1: Choose show to check progress");

		// update tracker
		System.out.println("#2: Update show progress");

					
		// view completed
		System.out.println("#3: View completed shows");
		//exit system
		System.out.println("#4: Exit the system.");
		System.out.println("==========================================================");
		System.out.println("==========================================================");
		System.out.println();

		try {
			
			while(ptcond) {
				Scanner scan = new Scanner(System.in);
				int response = getResponse(signed_in_options, scan);
				switch (response) {

				case 1:
					System.out.println("This is your progress");
					break;
				case 2:
					System.out.println("This will allow you to update progress");
					break;
				case 3:
					System.out.println("This will all you to view completed shows");
					break;
				case 4:
					ptcond = false;
					exit(0);
				}
				
				
				
				
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

	// gets menu response
	private static int getResponse(int range, Scanner scan) {

		boolean cond = true;
		int optHolder = -1;
		System.out.println("Enter your choice by number: ");

		while (cond) {

			try {

				optHolder = scan.nextInt();
				scan.nextLine();
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
	
	
	
	
	
	
	
	
	
	
	
	public boolean getExit() {
		return exit;
	}
}

	
