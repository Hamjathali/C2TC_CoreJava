package Day_2;

public class ContinueDemo {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; 
            }
            System.out.println("i = " + i);
        }

        System.out.println("Loop ended.");
    }

}

