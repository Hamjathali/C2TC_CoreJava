package Day_1;

public class TypeCasting {
	 public static void main(String[] args) {
		 
	        // Widening Casting (Automatic) — smaller to larger type
	        int intNum = 100;
	        double doubleNum = intNum;  // int → double (automatically)

	        System.out.println("Widening Casting:");
	        System.out.println("int value: " + intNum);
	        System.out.println("double value (after casting): " + doubleNum);

	        // Narrowing Casting (Manual) — larger to smaller type
	        double originalDouble = 99.99;
	        int castedInt = (int) originalDouble;  // double → int (manual)

	        System.out.println("\nNarrowing Casting:");
	        System.out.println("double value: " + originalDouble);
	        System.out.println("int value (after casting): " + castedInt);

	        // Example with char and int
	        char letter = 'A';
	        int asciiValue = letter;  // char → int (widening)
	        char convertedBack = (char) asciiValue;  // int → char (narrowing)

	        System.out.println("\nChar and Int Casting:");
	        System.out.println("char: " + letter);
	        System.out.println("ASCII value: " + asciiValue);
	        System.out.println("Converted back to char: " + convertedBack);
	    }

}
