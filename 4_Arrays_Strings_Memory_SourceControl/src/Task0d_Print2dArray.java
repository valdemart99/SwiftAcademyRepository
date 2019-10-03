
public class Task0d_Print2dArray {

	public static void main(String[] args) {
		int[][] matrix = new int [4][4];
		
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[i].length; ++j) {
				matrix[i][j] = (j+1) + (i * matrix.length);
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
