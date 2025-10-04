package Day_2;

public class NestedIfElseDemo {

	public static void main(String[] args) {
		
		int marks = 85;

        if (marks >= 50) {  // Outer if
            if (marks >= 90) {
                System.out.println("Grade: A+");
            } else if (marks >= 75) {
                System.out.println("Grade: A");
            } else if (marks >= 60) {
                System.out.println("Grade: B");
            } else {
                System.out.println("Grade: C");
            }
        } else {  // Outer else
            System.out.println("Grade: Fail");

        }
	}

}
