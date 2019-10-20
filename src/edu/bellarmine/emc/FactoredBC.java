package edu.bellarmine.emc;

import java.util.Scanner;

/**
 * This class implements a version of binomial coefficient calculation that
 * factors out part of the denominator, making it less computationally expensive.
 * 
 * @author Ethan Colbert
 * @version 1.0
 * Programming Project 3
 * Fall 2019
 */
public class FactoredBC {
	
	static long n, k, result;
	
	/**
	 * Execution starts here.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter the number of choices: ");
			n = input.nextLong();
			System.out.print("Enter how many to choose: ");
			k = input.nextLong();
		} while (!(k > 0 && n >= k));
		
		long numerator = 1, denominator = 1;
		
		if ((n-k) >= k) {
			
			for (int i = 1; i <= k; i++) {
				
				denominator *= i;
				
				numerator *= (n - i + 1);
				
			}
			
		}
		else {
			
			for (int j = 1; j <= (n-k); j++) {
				
				denominator *= j;
				
				numerator *= (n - j + 1);
				
			}
			
		}
		
		result = (numerator / denominator);
		
		System.out.printf("There are %d ways to choose %d items from %d choices.\n", result, k, n);
		
		input.close();
	}// end main

}// end class
