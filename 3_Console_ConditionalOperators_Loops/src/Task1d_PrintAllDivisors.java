import java.util.Scanner;

public class Task1d_PrintAllDivisors {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.close();
		String result = "1"; // Because every number is divisible by 1, so we can manage the intervals easily
		
		for (int i = 2; i <= number; i++) {
			if (number % i == 0) {
				result += " " + i;
			} 
		}
		System.out.println(result);
		
	}

}