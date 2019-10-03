import java.util.Scanner;

public class Task1d_PrintMatrix {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);	
		int size = input.nextInt();
		input.close();
		int[][] matrix = new int [size][size];
		int row = 0; int col = 0; char Direction = 'r';
		
		for (int i = 1; i <= (size * size); ++i) {
			matrix[row][col] = i;
			
			switch (Direction) {
				case 'r' : 
					if (col < size -1) {
						if (matrix[row][col+1] == 0) {
							col++;
						} else if (row < size - 1) {
							if (matrix[row+1][col] == 0) {
								row++; Direction = 'd';
							}
						}
					} else if (row < size - 1) {
						if (matrix[row+1][col] == 0) {
							row++; Direction = 'd';
						}
					}
					break;
				case 'l' : 
					if (col >0) {
						if (matrix[row][col-1] == 0) {
							col--;
						} else if (row >0) {
							if (matrix[row-1][col] == 0) {
								row--; Direction = 'u';
							}
						}
					} else if (row >0) {
						if (matrix[row-1][col] == 0) {
							row--; Direction = 'u';
						}
					}
					break;
				case 'u' : 
					if (row >0) {
						if (matrix[row-1][col] == 0) {
							row--;
						} else if (col < size - 1 ) {
							if (matrix[row][col+1] == 0) {
								col++; Direction = 'r';
							}
						}
					} else if (col < size - 1 ) {
						if (matrix[row][col+1] == 0) {
							col++; Direction = 'r';
						}
					}
					break;
				case 'd' : 
					if (row < size - 1 ) {
						if (matrix[row+1][col] == 0) {
							row++;
						} else if (col > 0 ) {
							if (matrix[row][col-1] == 0) {
								col--; Direction = 'l';
							}
						}
					} else if (col > 0 ) {
						if (matrix[row][col-1] == 0) {
							col--; Direction = 'l';
						}
					}
					break;
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
