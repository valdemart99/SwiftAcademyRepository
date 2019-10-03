import java.util.Scanner;

public class Task1e_IsPrime {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.close();
		boolean primeCheck = true;
		
		for (int i = 1; i <= number; i++) {
			if (number % i == 0 && i != 1 && i != number) {
				primeCheck = false; break;
			}
		}
		System.out.println(primeCheck);
	}

}