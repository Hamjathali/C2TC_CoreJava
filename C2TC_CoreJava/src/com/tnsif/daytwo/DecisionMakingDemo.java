package com.tnsif.daytwo;
import java.util.Scanner;

public class DecisionMakingDemo {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Example 1: if statement
	        System.out.print("Enter a number: ");
	        int num = sc.nextInt();

	        if (num > 0) {
	            System.out.println(num + " is positive.");
	        }

	        // Example 2: if-else statement
	        if (num % 2 == 0) {
	            System.out.println(num + " is even.");
	        } else {
	            System.out.println(num + " is odd.");
	        }

	        // Example 3: if-else-if ladder
	        if (num > 0) {
	            System.out.println(num + " is positive.");
	        } else if (num < 0) {
	            System.out.println(num + " is negative.");
	        } else {
	            System.out.println("The number is zero.");
	        }

	        
	        

	 }
}
