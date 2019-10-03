import java.util.Scanner;

public class Task0d_ReadNNumbers2_var2 {

	public static void main(String[] args) {
		
		// Variant 2 - auto fill numbers from 1 to entered number
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.close();
		
		for (int i = 1; i <= number; i++) {
			System.out.println(i);
		}
		
	}

}