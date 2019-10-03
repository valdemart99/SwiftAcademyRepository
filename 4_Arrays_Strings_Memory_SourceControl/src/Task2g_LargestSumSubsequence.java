import java.util.*;

public class Task2g_LargestSumSubsequence {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] matrix = new int[input.nextInt()];
		input.nextLine();
		
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = input.nextInt();
		}		
		input.close();
		
		int startIndex = 0; int endIndex = matrix.length -1; int splitIndex = -1;
		int leftSum = 0; int rightSum = 0;
		
		while (true) {
			// Create a temporary array to sort it so we can easily find the lowest number in the subArray
			int subArray[] = Arrays.copyOfRange(matrix, startIndex, endIndex);
			Arrays.sort(subArray);
			int minNumberSubArray = subArray[0];
			if (minNumberSubArray > 0) { break;	} // This is an early exit condition
			
			splitIndex = -1; // make sure the index is reset and sums are reset
			leftSum = 0; rightSum = 0;
			
			// we go over the subArray and calculate sums and index of the lowest number 
			for (int j = startIndex; j < endIndex; j++) {
				if (matrix[j] == minNumberSubArray) {
					splitIndex = j;
				} else if (splitIndex < 0) {
					leftSum += matrix[j];
				} else {
					rightSum += matrix[j];
				}
			}
			
			if (-matrix[splitIndex] > leftSum || -matrix[splitIndex] > rightSum) {
				if (leftSum >= rightSum) {
					endIndex = splitIndex - 1;
				} else {
					startIndex = splitIndex + 1;
				}
			} else {
				break; // This is the line that exits the loop
			}
			
		}
		
		for (int p = startIndex; p <= endIndex; p++) {
			System.out.print(matrix[p] + (p < endIndex ? " " : ""));
		}
		
	}

}
