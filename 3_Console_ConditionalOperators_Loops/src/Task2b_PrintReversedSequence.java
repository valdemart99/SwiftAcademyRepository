import java.util.Scanner;

public class Task2b_PrintReversedSequence {

	public static void main(String[] args) {
		
		// Variant 1 - manual number input
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.nextLine();
		String reverse = "";
		
		for (int i = 1; i <= number; i++) {
			int nextNum = sc.nextInt();
			reverse = nextNum + (i==1 ? "" : " ") + reverse; 
		}
		
		sc.close();
		System.out.println(reverse);
		
	}

}