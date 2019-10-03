import java.util.Scanner;

public class Task3c_PrintChristmasTree {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.close();
		
		for (int i = 1; i <= number + 2; i++) {
			for (int j = 1; j <= (number * 2) - 1 ; j++) {
				if ((j >= number - i + 1 && j <= number + i - 1 && i <= number) ||
					(j >= (number * 2) - i + 1 && j <= i - 1 && i > number)) { // Logic simplified from [number +/- (i - number -1)]
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}

}