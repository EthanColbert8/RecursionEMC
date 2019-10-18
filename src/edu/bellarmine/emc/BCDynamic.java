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
	
	static long n, k, result;
	
	/**
	 * Execution starts here.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("This is the dynamic version of BC.");//making sure I'm testing the right program.
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter the number of choices: ");
			n = input.nextLong();
			System.out.print("Enter how many to choose: ");
			k = input.nextLong();
		} while (!(k > 0 && n >= k));
		
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
		
		System.out.printf("There are %d ways to choose %d items from %d choices.", result, k, n);
		
		input.close();
	}// end main

}// end "BCDynamic" class