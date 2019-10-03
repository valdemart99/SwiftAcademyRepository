import java.util.Scanner;

public class Task2c_PrintOnlyEvenNumbers {

	public static void main(String[] args) {
		
		// Variant 1 - manual number input
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.nextLine();
		String even = "";
		
		for (int i = 1; i <= number; i++) {
			int nextNum = sc.nextInt();
			if (nextNum % 2 == 0) {
				even = even + (even.length() == 0 ? "" : " ") + nextNum; 
			}
		}
		
		sc.close();
		System.out.println(even);
		
	}

}