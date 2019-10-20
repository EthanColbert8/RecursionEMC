package edu.bellarmine.emc;

import java.math.BigInteger;
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
	
	static long n, k, result;
	
	/**
	 * Execution starts here.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("This is the recursive version of BC.");//making sure I'm testing the right program.
		Scanner input = new Scanner(System.in);
		
		Scanner input2 = new Scanner(System.in);
		boolean goAgain = true;
		String userChoice;
		do {
			
			do {
				System.out.print("Enter the number of choices: ");
				n = input.nextLong();
				System.out.print("Enter how many to choose: ");
				k = input.nextLong();
			} while (!(k > 0 && n >= k));
			
			long numerator = factorial(n);
			long denominator1 = factorial(k);
			long denominator2 = factorial(n - k);
			
			result = (numerator / (denominator1 * denominator2));
			
			System.out.printf("There are %d ways to choose %d items from %d choices.\n", result, k, n);
			
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