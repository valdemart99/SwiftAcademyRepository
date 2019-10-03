import java.util.Scanner;

public class Task1b_PrintMatrix {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);	
		int size = input.nextInt();
		input.close();
		int[][] matrix = new int [size][size];
		
		for (int row = 0; row < matrix.length; ++row) {
			for (int col = 0; col < matrix[row].length; ++col) {
				matrix[row][col] = (matrix.length * col) + 
									( col % 2 ==0 ? row + 1 : matrix.length - row );
			}
		}

		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[i].length; ++j) {
				System.out.print(matrix[i][j] + " " +(matrix[i][j]<10 ? " " : ""));
				// Additional interval for formatting reasons
			}
			System.out.println();
		}
	}

}
