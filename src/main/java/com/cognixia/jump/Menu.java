/**
 * @authors Jacob Laws, Michelle Lovse, Gabriel Ortiz, Toju Mikie
 * @version 1.1
 */


package com.cognixia.jump;

import static java.lang.System.exit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.TvShowDAO;
import com.cognixia.jump.dao.UDAO;
import com.cognixia.jump.dao.UserDAO;
import com.cognixia.jump.exceptions.InputOver255CharactersException;

public class Menu {
	//declaring variables that will be accessible for methods
	public final static Scanner scan = new Scanner(System.in);
	//declaring id variable so that the variable can be stored after user is logged in for later use
	public static Integer id = 0;
	//Instantiating the DAO's 
	static UserDAO userDAO = new UserDAO();
	static TvShowDAO tvshowDAO = new TvShowDAO();
	static UDAO uDAO = new UDAO();
	//variables used for the menu switch case setups
	private static final int signed_in_options = 4;
	private static final int log_in_options = 3;
	//allows program to exit...uses the java.lang.System.exit import
	private boolean exit;
	//Calls connection manager
	private static Connection conn = ConnectionManager.getConnection();

	public static void main(String[] args) {
		//setting up prepared statements, query, and result set for future use
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
//		Scanner scan = new Scanner(System.in);
		//1UserDAO userDAO = new UserDAO();

		boolean loginCond = true;
		System.out.println();
		System.out.println("==========================================================");
		System.out.println("=            Please chooose an option?                   =");
		System.out.println("==========================================================");
		System.out.println();

		try {
			//checks if login has been successful
			while (loginCond) {
				//calls function with menu options
				LoginOptions();
				//variable gets user response, get Response function checks that the user input
				//is valid
				int response = getResponse(log_in_options, scan);

				switch (response) {

				case 1:

//					//variables to get the user's username and password
					String getUsername = "";
					String getPassword = "";

					try {

						System.out.println("Enter username: ");
						getUsername = scan.nextLine();
						//checks to ensure username does not exceed the varchar count for field in db
						if (getUsername.length() > 255)
							throw new InputOver255CharactersException(getUsername.length());

						System.out.println("Enter password: ");
						getPassword = scan.nextLine();
						//checks to ensure password does not exceed varchar count of field in db
						if (getPassword.length() > 255)
							throw new InputOver255CharactersException(getPassword.length());

					} catch (InputOver255CharactersException e) {
						//error message displayed when user inputs more than acceptable length of characters
						System.out.println("Input over max length (255 characters)");

					}
					//prepared statement to check for inputted username and password in db
					pstmt = conn.prepareStatement("select * from user where username = ? and password = ?");

					pstmt.setString(1, getUsername);
					pstmt.setString(2, getPassword);

					rs = pstmt.executeQuery();
					//if a result set is not found, then user is prompted to reenter username/password
					if (!rs.next()) {
						System.out.println("Incorrect username or password -- Please try again!\n");
						getUsername = "";
						continue;
					} else {
						System.out.println("Login Successful!");
						//id being saved for later use
						 id = rs.getInt("user_id");

						// Send to Admin options
						if (id == 1)
							AdminSignedInlistOptions();
						else
							// System.out.println(id);
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
					userDAO.addUser();
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
//function with login menu options
	private static void LoginOptions() {

		System.out.println("========================OPTIONS===========================");
		System.out.println("==========================================================");
		System.out.println("Please select an option: ");
		System.out.println("#1: Log In");
		System.out.println("#2: Exit System");
		System.out.println("#3: Add a User");
	}

//console menu displayed after user is logged in
	private static void SignedInlistOptions() {
		boolean ptcond = true;

		System.out.println("====================PROGRESS TRACKER======================");
		System.out.println("==========================================================");
		System.out.println("Please select an option: ");
		// view progess
		System.out.println("#1: List of your shows and progress");

		// update tracker
		System.out.println("#2: Update a show's progress");

		// view completed
		System.out.println("#3: View your completed shows");
		// exit system
		System.out.println("#4: Exit the system.");
		System.out.println("==========================================================");
		System.out.println("==========================================================");
		System.out.println();

		try {

			while (ptcond) {
				Scanner scan = new Scanner(System.in);
				int response = getResponse(signed_in_options, scan);
				switch (response) {
				// all shows and make changes to tracker
				//case 1: makes call to database to return shows that match the user's id
				case 1:

					System.out.println("These are the shows in your list.");

					PreparedStatement pstmt = conn
							.prepareStatement("select tv_show_name as 'Show Name', progress from tv_show "
									+ "join user_tv_show on tv_show.tv_show_id = user_tv_show.show_id "
									+ "join user on user.user_id = user_tv_show.user_id " + "where user.user_id = ?");
					// System.out.println(id);
					pstmt.setInt(1, id);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						String resultShow = rs.getString("Show Name");
						Integer resultInt = rs.getInt("progress");
						String resultIntString = "";
						//if statements to display string vs an int to users to make it more user friendly
						if (resultInt == 0) {
							resultIntString = "Not Started";
						}
						if (resultInt == 1) {
							resultIntString = "In Progress";
						}
						if (resultInt == 2) {
							resultIntString = "Completed";
						}
						//format to make results look uniform
						System.out.printf("%-30.30s  %-30.30s\n", resultShow, resultIntString);
					}
					SignedInlistOptions();
					break;
				case 2:
					System.out.println(id);
					Integer progressShowID = 0;
					System.out.println("Updating show progress");
					String progessToUpdate = "";
					System.out.println("Enter the name of the show you wish to update.");
					progessToUpdate = scan.nextLine();
					//gets id of show that user entered based on match to show name
					pstmt = conn.prepareStatement("select tv_show_id from tv_show where " + "tv_show_name = ?");
					
					pstmt.setString(1, progessToUpdate);
					
					rs = pstmt.executeQuery();
					rs.next();
					progressShowID = rs.getInt("tv_show_id");
					
					System.out.println(progressShowID);
					//prompts user to enter numeric entry to update the show's progress
					System.out.println("Enter value you would like to update show with: \n" + "0: Not Started \n"
							+ "1: In Progress \n" 
							+ "2: Completed \n");
					Integer getNewProgress = scan.nextInt();
					
					pstmt = conn.prepareStatement("update user_tv_show "
							+ "set progress = ? "
							+ "where user_id = ? and show_id = ?");
					
						pstmt.setInt(1, getNewProgress);
						pstmt.setInt(2, id);
						pstmt.setInt(3, progressShowID);
						
						pstmt.executeUpdate();
						//TODO: incorporate function from UDAO to handle updating progress

					//uDAO.updateProgressOfTvShow(getNewProgress, id, progressShowID);
					break;
				case 3:
					System.out.println("Completed shows");
					//TODO: create function in UDAO to handle database call and returning results
					
					//prepared statement that joins tv show, user, and user_tv_show tables to return list of shows that 
					//have a completed status that corresponds to user's id 
					PreparedStatement pstmt1 = conn
							.prepareStatement("select tv_show_name as 'Show Name', progress from tv_show "
									+ "join user_tv_show on tv_show.tv_show_id = user_tv_show.show_id "
									+ "join user on user.user_id = user_tv_show.user_id "
									+ "where user.user_id = ? and progress = ?");
					// System.out.println(id);
					pstmt1.setInt(1, id);
					pstmt1.setInt(2, 2);
					ResultSet rs1 = pstmt1.executeQuery();
					while (rs1.next()) {
						String resultShow = rs1.getString("Show Name");
						Integer resultInt = rs1.getInt("progress");
						System.out.println(resultShow);
					}
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

	//signed in options for admin user
		//TODO: fully implement all administrator options
		private static void AdminSignedInlistOptions() {
			boolean ptcond = true;

			System.out.println("=================ADMINISTRATOR SIGNED IN===================");
			System.out.println("===========================================================");
			System.out.println("Please select an option:");
			System.out.println("#1: Add a new topic");
			System.out.println("#2: Remove a topic");
			System.out.println("#3: Edit topic info");
			System.out.println("#4: Exit the system");
			System.out.println("===========================================================");
			System.out.println("===========================================================");
			System.out.println();

			try {

				while (ptcond) {

					Scanner scan = new Scanner(System.in);
					int response = getResponse(signed_in_options, scan);
					String query = "";
					
					
					switch(response) {
					
						case 1:
							
							//insert into the tv show table values = tv show name, leading actor, director,
							//genre, rating, show's first episode, number of seasons, number of episodes,
							//audience score, and status.
							query = "insert into tv_show values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
							
							//selects the maximum id from the tv show table
							//TODO: make a more sophisticated id grabber
							String getLastID = "select MAX(tv_show_id) from tv_show";
									
							PreparedStatement pstmt = conn.prepareStatement(getLastID);
							ResultSet rs = pstmt.executeQuery();
							int lastID = -1;
							
							//rs.next() not only checks if an item exists, but it also iterates through it
							if(rs.next()) {
								
								lastID = rs.getInt(1);
							
								//TODO: use only one PreparedStatement object
								PreparedStatement pstmt2 = conn.prepareStatement(query);
								String name = "", actor = "", director = "", genre = "", rating = "", firstEpisode = "", status = "";
								int numOfSeasons = 0, numOfEpisodes = 0, audienceScore = 0;
								
								//gather's user input for each of the show's values
								System.out.println("Please enter the show's name:");
								name = Menu.scan.nextLine();
								System.out.println("Please enter the show's leading actor:");
								actor = Menu.scan.nextLine();
								System.out.println("Please enter the show's director:");
								director = Menu.scan.nextLine();
								System.out.println("Please enter the show's number of seasons:");
								numOfSeasons = Menu.scan.nextInt();
								System.out.println("Please enter the show's number of episodes:");
								numOfEpisodes = Menu.scan.nextInt();
								System.out.println("Please enter the show's genre:");
								Menu.scan.nextLine();
								genre = Menu.scan.nextLine();
								System.out.println("Please enter the show's audience score:");
								audienceScore = Menu.scan.nextInt();
								System.out.println("Please enter the show's rating:");
								Menu.scan.nextLine();
								rating = Menu.scan.nextLine();
								System.out.println("Please enter the show's first episode's name:");
								firstEpisode = Menu.scan.nextLine();
								System.out.println("Please enter the show's status:");
								status = Menu.scan.nextLine();
								
								
								//sets each value for the tv show for each '?' in query
								
								//TODO: update junction table simultaneously to set default values for
								//new shows. Admins by default have watched all shows and users by default
								//have watched none (unless they change their status)
								pstmt2.setInt(1, lastID + 1);
								pstmt2.setString(2, name);
								pstmt2.setString(3, actor);
								pstmt2.setString(4, director);
								pstmt2.setInt(5, numOfSeasons);
								pstmt2.setInt(6, numOfEpisodes);
								pstmt2.setString(7, genre);
								pstmt2.setInt(8, audienceScore);
								pstmt2.setString(9, rating);
								pstmt2.setString(10, firstEpisode);
								pstmt2.setString(11, status);
								
								//executeUpdate is used for DML like INSERT, UPDATE, DELETE
								pstmt2.executeUpdate();
								System.out.println("Added topic.");
									
							}		
							break;
							
						case 2:
							
							//currently bugged:  Cannot delete or update a parent row: a foreign key constraint fails 
							
							//TODO: need to find a way to delete rows from the junction table at the same time as deleting
							//a record from the table
							System.out.println("Enter the ID of the topic you would like to delete:");
							int idChoice = scan.nextInt();
							query = "delete from tv_show where tv_show_id = ?";
							PreparedStatement pstmt3 = conn.prepareStatement(query);
							pstmt3.setInt(1, idChoice);
							int numUpdates = pstmt3.executeUpdate();
							if(numUpdates > 0)
								System.out.println("Operation successful");
							else
								System.out.println("Opperation unsuccessful");
							break;
							
							
							
						case 3:
							
							//TODO: implement a feature to edit a topic's information
							System.out.println();
							break;
							
						case 4:
						default:
							ptcond = false;
							exit(0);
						}

					}

			} catch (Exception e) {

				e.printStackTrace();

			}
		}

	// gets menu response
	//method checks to ensure that the user's entered response is within range of menu options available
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
