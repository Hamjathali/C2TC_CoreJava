package com.tnsif.daytwo;

public class ForEachLoopDemo {
	public static void main(String[] args) {
        
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Numbers in the array:");
        for (int num : numbers) {
            System.out.println(num);
        }

        String[] fruits = {"Apple", "Banana", "Mango", "Orange"};

        System.out.println("\nList of fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }

}
