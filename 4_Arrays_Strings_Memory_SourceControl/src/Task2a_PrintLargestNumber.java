import java.util.Scanner;
import java.util.Arrays;

public class Task2a_PrintLargestNumber {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);		
		int[] masiv = new int[input.nextInt()];
		input.nextLine();
		
		for (int i = 0; i < masiv.length; i++) {
			masiv[i] = input.nextInt();
		}		
		input.close();
		
		Arrays.sort(masiv);
		for (int number: masiv) {
			System.out.printf("%d ", number);
		}

	}

}
