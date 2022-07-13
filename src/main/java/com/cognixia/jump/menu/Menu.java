package com.cognixia.jump.menu;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	private static final int options = 4;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		boolean cond = true;
		System.out.println();
		System.out.println("==========================================================");
		System.out.println("=            Please chooose an option?                   =");
		System.out.println("==========================================================");
		System.out.println();

		while (cond) {
			listOptions();
			int response = getResponse(options, scan);

			switch (response) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;

			}

		}

	}

//console menu	
	private static void listOptions() {
		System.out.println("========================OPTIONS===========================");
		System.out.println("==========================================================");
		System.out.println("Please select an option: ");
		System.out.println("#1: Replace with option 1");
		System.out.println("#2: Replace with option 2");
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
