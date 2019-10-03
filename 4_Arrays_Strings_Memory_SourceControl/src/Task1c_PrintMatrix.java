import java.util.Scanner;

public class Task1c_PrintMatrix {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);	
		int size = input.nextInt();
		input.close();
		int[][] matrix = new int [size][size];
		int row = 0; int col = 0; String Direction = "up";
		
		for (int i = 1; i <= (size * size); ++i) {
			matrix[row][col] = i;
			
			if (Direction == "up") {
				if (row > 0) {
					if (col < size -1) {
						row--; col++;
					} else {
						row++; Direction = "down";
					}
				} else {
					if (col < size -1 ) {
						col++;
					} else {
						row++; 
					}
					Direction = "down";
				}
			} else {
				if (col > 0) {
					if (row < size - 1 ) {
						row++; col--;
					} else {
						col++; Direction = "up";
					}
				} else {
					if (row < size -1 ) {
						row++;
					} else {
						col++; 
					}
					Direction = "up";
				}
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
