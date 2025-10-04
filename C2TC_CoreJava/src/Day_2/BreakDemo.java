package Day_2;

public class BreakDemo {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("Break at i = " + i);
                break;  // Exit the loop when i is 5
            }
            System.out.println("i = " + i);
        }

        System.out.println("Loop ended after break.");
	}

}
