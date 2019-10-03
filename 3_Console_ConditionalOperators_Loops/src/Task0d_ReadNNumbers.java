import java.util.Scanner;

public class Task0d_ReadNNumbers {

	public static void main(String[] args) {
		
		// Variant 1 - manual number input
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.nextLine();
		
		for (int i = 1; i <= number; i++) {
			int nextNum = sc.nextInt();
			System.out.println(nextNum);
		}
		sc.close();
		
	}

}