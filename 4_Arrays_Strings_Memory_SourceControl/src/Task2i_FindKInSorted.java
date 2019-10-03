import java.util.*;

public class Task2i_FindKInSorted {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int matrixSize = input.nextInt();
		int k = input.nextInt();
		int[] matrix = new int[matrixSize];
		input.nextLine();
		
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = input.nextInt();
		}		
		input.close();
		
		Arrays.sort(matrix);
		
		if (matrix[0] > k || matrix[matrix.length -1 ] < k) {
			System.out.println("NO");
		} else {		
			for (int j = 0; j < matrix.length; ++j) {
				if (matrix[j] == k) {
					System.out.println(j);
					break;
				} else if (matrix[j] > k) {
					System.out.println("NO");
					break;
				}
			}
		}
	}

}
