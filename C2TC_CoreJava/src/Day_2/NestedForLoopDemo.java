package Day_2;

public class NestedForLoopDemo {

	public static void main(String[] args) {
		
		System.out.println("Multiplication Table:");
        for (int i = 1; i <= 5; i++) {             
            for (int j = 1; j <= 5; j++) {         
                System.out.print(i * j + "\t");
            }
            System.out.println(); 
        }

        
        System.out.println("\nStar Pattern:");
        for (int i = 1; i <= 5; i++) {            
            for (int j = 1; j <= i; j++) {        
                System.out.print("* ");
            }
            System.out.println(); 

        }
	}

}
