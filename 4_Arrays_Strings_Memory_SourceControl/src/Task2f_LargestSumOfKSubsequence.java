import java.util.Scanner;

public class Task2f_LargestSumOfKSubsequence {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int matrixSize = input.nextInt();
		int[] matrix = new int[matrixSize];
		int k = input.nextInt();
		input.nextLine();
		
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = input.nextInt();
		}		
		input.close();
		
		StringBuilder currentSeq = new StringBuilder();
		StringBuilder lastSeq = new StringBuilder();
		int currentSum = 0;
		int lastSum = Integer.MIN_VALUE;
		
		for (int i = 0; i <= matrix.length - k; i ++) {
			for (int j = i; j < i + k; j++) {
				currentSum += matrix[j];
				if (j > i) {
					currentSeq = currentSeq.append(" ");
				}
				currentSeq = currentSeq.append(matrix[j]);
			}
			if ( currentSum > lastSum ) {
				lastSeq = currentSeq;
				lastSum = currentSum;
			}
			currentSum = 0;
			currentSeq = new StringBuilder();	
		}
		
		System.out.println(lastSeq);
	}

}
