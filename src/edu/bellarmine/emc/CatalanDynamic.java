package edu.bellarmine.emc;

import java.util.Scanner;

/**
 * This class implements the dynamic version of Catalan number calculation.
 * 
 * @author Ethan Colbert
 * @version 1.0
 * Programming Project 3
 * Fall 2019
 */

public class CatalanDynamic {
	
	static long n, c;//the input and result of calculation
	static long startTime, endTime;//timestamps for the start and end of calculation
	static double elapsedSeconds;//time taken to compute, measured in seconds
	
	/**
	 * Execution starts here.
	 * @param args
	 */
	public static void main(String[] args) {
		
System.out.println("This is the dynamic version of Catalan number calculation.");//Lets us know what program we're running.
		
		Scanner input = new Scanner(System.in);//lets us enter n
		TextWriter recordWriter = new TextWriter("CatalanDynamicResults.txt");//handles the writing of records to the file
		
		/* If I tried to use the first Scanner to get the the "userChoice" String, it wouldn't work.
		 * So I added this one. */
		Scanner input2 = new Scanner(System.in);
		boolean goAgain = true;//whether or not to do another calculation
		String userChoice;//what the user typed
		do {
			
			do {
				System.out.print("Enter the which Catalan number to calculate (n): ");
				n = input.nextLong();
			} while (!(n >= 0));
			
			startTime = System.currentTimeMillis();
			
			long numerator = 1, denominator1 = 1, denominator2 = 1;
			
			for (int i = 1; i <= 2*n; i++) {
				
				numerator *= i;
				
				if (i == n) {
					denominator1 = numerator;
				}
				
				if (i == (n + 1)) {
					denominator2 = numerator;
				}
				
			}
			
			c = numerator / (denominator1 * denominator2);
			
			endTime = System.currentTimeMillis();
			elapsedSeconds = ((double)(endTime - startTime)) / 1000.0;//dividing by 1000 converts from milliseconds to seconds.
			
			System.out.printf("C(%d) = %d\n", n, c);
			
			/* This block writes a record of the calculation to the file according to the specifications. */
			if (elapsedSeconds < 1.0) {
				recordWriter.writeRecord(n + ", " + c + ", 1 second.");
			}
			else {
				recordWriter.writeRecord(n + ", " + c + ", " + elapsedSeconds + " seconds.");
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

}// end "CatalanDynamic" class