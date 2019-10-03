import java.util.Scanner;

public class Task2a_PrintSumOfN {

	public static void main(String[] args) {
		
		// Variant 1 - manual number input
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.nextLine();
		int sum = 0;
		
		for (int i = 1; i <= number; i++) {
			int nextNum = sc.nextInt();
			sum += nextNum;
		}
		sc.close();
		System.out.println(sum);
		
	}

}