package edu.bellarmine.emc;

import java.util.Scanner;

/**
 * This class implements the recursive version of binomial coefficient calculation.
 * 
 * @author Ethan Colbert
 * @version 1.0
 * Programming Project 3
 * Fall 2019
 */

public class BCRecursive {
	
	static long n, k, result;//the input and results of the calculation
	static long startTime, endTime;//timestamps for the start and end of computation
	static double elapsedSeconds;//the time it took to compute, measured in seconds
	
	/**
	 * Execution starts here.
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("This is the recursive version of BC.");//Lets us know which program we're running.
		
		Scanner input = new Scanner(System.in);//lets us enter n and k
		TextWriter recordWriter = new TextWriter("BCRecursiveResults.txt");//handles the writing of records to the file
		
		/* If I tried to use the first Scanner to get the the "userChoice" String, it wouldn't work.
		 * So I added this one. */
		Scanner input2 = new Scanner(System.in);
		boolean goAgain = true;//whether or not to do another calculation
		String userChoice;//what the user typed
		do {
			
			/* This block gathers and validates input, prompting the user again if input is invalid. */
			do {
				System.out.print("Enter the number of items to choose from: ");
				n = input.nextLong();
				System.out.print("Enter how many to choose: ");
				k = input.nextLong();
			} while (!(k >= 0 && n >= k));
			
			startTime = System.currentTimeMillis();
			
			long numerator = factorial(n);
			long denominator1 = factorial(k);
			long denominator2 = factorial(n - k);
			
			result = (numerator / (denominator1 * denominator2));
			
			endTime = System.currentTimeMillis();
			elapsedSeconds = ((double)(endTime - startTime)) / 1000.0;//dividing by 1000 converts from milliseconds to seconds.
			
			System.out.printf("There are %d ways to choose %d items from %d choices.\n", result, k, n);
			
			/* This block writes a record of the calculation to the file according to the specifications. */
			if (elapsedSeconds < 1.0) {
				recordWriter.writeRecord(n + ", " + k + ", " + result + ", 1 second.");
			}
			else {
				recordWriter.writeRecord(n + ", " + k + ", " + result + ", " + elapsedSeconds + " seconds.");
			}
			
			System.out.print("Do you want to compute another value (Yes or No)? ");
			userChoice = input2.nextLine();
			if (userChoice.toLowerCase().charAt(0) != 'y') {
				goAgain = false;
			}
		} while (goAgain);
		
		input.close();
		input2.close();
	}// end main
	
	/**
	 * SUPPORT METHOD - returns the factorial of the number passed in.
	 * Will return -1 if the number passed in is negative.
	 * @param input - a positive integer
	 * @return the factorial of input
	 */
	private static long factorial(long input) {
		
		if (input < 0) {
			return -1;
		}
		else if (input == 0 || input == 1) {
			return 1;
		}
		else {
			return (input * factorial(input - 1));
		}
		
	}// end "factorial" support method
	
}// end "BCRecursive" class