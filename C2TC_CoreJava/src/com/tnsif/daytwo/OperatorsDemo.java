package com.tnsif.daytwo;

public class OperatorsDemo {

	public static void main(String[] args) {
		
		int a = 10;
        int b = 5;
        int c;

        // Arithmetic Operators
        System.out.println("=== Arithmetic Operators ===");
        System.out.println("a + b = " + (a + b));   
        System.out.println("a - b = " + (a - b));   
        System.out.println("a * b = " + (a * b));   
        System.out.println("a / b = " + (a / b));   
        System.out.println("a % b = " + (a % b));   

        // Relational (Comparison) Operators
        System.out.println("\n=== Relational Operators ===");
        System.out.println("a == b : " + (a == b)); 
        System.out.println("a != b : " + (a != b)); 
        System.out.println("a > b  : " + (a > b));  
        System.out.println("a < b  : " + (a < b));  
        System.out.println("a >= b : " + (a >= b)); 
        System.out.println("a <= b : " + (a <= b)); 

        // Logical Operators
        boolean x = true;
        boolean y = false;
        System.out.println("\n=== Logical Operators ===");
        System.out.println("x && y : " + (x && y)); 
        System.out.println("x || y : " + (x || y)); 
        System.out.println("!x     : " + (!x));     

        // 4️⃣ Assignment Operators
        System.out.println("\n=== Assignment Operators ===");
        c = a; 
        System.out.println("c = " + c);
        c += b;  
        System.out.println("c += b : " + c);
        c -= b;  
        System.out.println("c -= b : " + c);
        c *= b; 
        System.out.println("c *= b : " + c);
        c /= b;  
        System.out.println("c /= b : " + c);
        c %= b;  
        System.out.println("c %= b : " + c);

        // 5️⃣ Unary Operators
        System.out.println("\n=== Unary Operators ===");
        int num = 5;
        System.out.println("num = " + num);
        System.out.println("++num = " + (++num));  
        System.out.println("num++ = " + (num++));  
        System.out.println("num after num++ = " + num);
        System.out.println("--num = " + (--num));  
        System.out.println("num-- = " + (num--));  
        System.out.println("num after num-- = " + num);

	}

}
