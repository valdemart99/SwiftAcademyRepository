import java.util.Scanner;

public class Task2e_LongestIncreasingSubsequence {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		
		int[] matrix = new int[input.nextInt()];
		input.nextLine();
		
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = input.nextInt();
		}		
		input.close();
		
		StringBuilder currentSeq = new StringBuilder();
		StringBuilder lastSeq = new StringBuilder();
		int currentLength = 0;
		int lastLength = 0;
		boolean subArrCheck = false;
		
		for (int i = 0; i < matrix.length -1; i ++) {
			if (matrix[i] <= matrix[i + 1]) {
				if (subArrCheck == true) {
					currentSeq = currentSeq.append(" " + matrix[i + 1]);
				} else {
					subArrCheck = true;
					currentSeq = currentSeq.append(matrix[i] + " "+ matrix[i + 1]);
					currentLength += 1;
				}
				currentLength += 1;
			} else if (subArrCheck == true) {
				if (currentLength > lastLength) {
					lastLength = currentLength;
					lastSeq = currentSeq;
				}
				subArrCheck = false;
				currentLength = 0;
				currentSeq = new StringBuilder();
			}
		}
		
		System.out.println(lastSeq);
	}

}
