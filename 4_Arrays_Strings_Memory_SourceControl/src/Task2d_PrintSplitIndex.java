import java.util.Scanner;

public class Task2d_PrintSplitIndex {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);		
		int[] masiv = new int[input.nextInt()];
		input.nextLine();
		int arrSum = 0;
		
		for (int i = 0; i < masiv.length; i++) {
			masiv[i] = input.nextInt();
			arrSum += masiv[i];
		}		
		input.close();
		
		int cumulativeSum = 0;
		int index = -1;
		for (int j = 0; j < masiv.length; j++) {
			cumulativeSum += masiv[j];
			if (cumulativeSum * 2 == arrSum) {
				index = j; break;
			}
		}
		
		System.out.println( index >= 0 ? index : "No");

	}

}
