import java.util.Scanner;

public class Task1a_PrintFirstDigit {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.close();
		while (number >=10) {
			number /= 10;
		}
		System.out.println(number);
		
	}

}