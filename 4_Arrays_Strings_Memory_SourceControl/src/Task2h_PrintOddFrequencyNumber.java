import java.util.*;

public class Task2h_PrintOddFrequencyNumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] matrix = new int[input.nextInt()];
		input.nextLine();
		
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = input.nextInt();
		}		
		input.close();
		
		Arrays.sort(matrix);
		int counter = 0; boolean check = false;
		
		for (int i = 0; i < matrix.length; ++i) {
			if (i == matrix.length - 1) {
				if (check && counter % 2 == 1) {
					System.out.println(matrix[i]);
				}
				break;
			}
			
			if (matrix[i] == matrix [i + 1]) {
				if (check) {
					counter++;
				} else {					
					counter = 2; check = true;
				}
				
			} else {
				if (i == 0) {
					System.out.println(matrix[i]);
					break;
				} else if (counter % 2 == 0) {
					counter = 0; check = false;
				} else {
					System.out.println(matrix[i]);
					break;
				}
			} 
		}
		
		
		
	}

}
