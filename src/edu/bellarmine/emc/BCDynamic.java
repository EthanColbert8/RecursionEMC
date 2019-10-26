package edu.bellarmine.emc;

import java.util.Scanner;

/**
 * This class implements the dynamic version of binomial coefficient calculation.
 * 
 * @author Ethan Colbert
 * @version 1.0
 * Programming Project 3
 * Fall 2019
 */

public class BCDynamic {
	
	static long n, k, result;//the input and results of the calculation
	static long startTime, endTime;//timestamps for the start and end of computation
	static double elapsedSeconds;//the time it took to compute, measured in seconds
	
	/**
	 * Execution starts here.
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("This is the dynamic version of BC.");//Lets us know which program we're running.
		
		Scanner input = new Scanner(System.in);//lets us enter n and k
		TextWriter recordWriter = new TextWriter("BCDynamicResults.txt");//handles the writing of records to the file
		
		/* If I tried to use the first Scanner to get the the "userChoice" String, it wouldn't work.
		 * So I added this one. */
		Scanner input2 = new Scanner(System.in);
		boolean goAgain = true;//whether or not to do another calculation
		String userChoice;//what the user typed
		do {
			
			/* This block gathers and validates input, prompting the user again if input is invalid. */
			do {
				System.out.print("Enter the number of choices: ");
				n = input.nextLong();
				System.out.print("Enter how many to choose: ");
				k = input.nextLong();
			} while (!(k >= 0 && n >= k));
			
			startTime = System.currentTimeMillis();
			
			long numerator = 1, denominator1 = 1, denominator2 = 1;
			
			for (int i = 1; i <= n; i++) {
				
				numerator *= i;
				
				if (i == k) {
					denominator1 = numerator;
				}
				
				if (i == (n - k)) {
					denominator2 = numerator;
				}
				
			}
			
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

}// end "BCDynamic" class