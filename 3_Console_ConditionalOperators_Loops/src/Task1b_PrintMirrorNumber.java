import java.util.Scanner;

public class Task1b_PrintMirrorNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.close();
		String result = "";
		
		while (number > 0) {
			result += number % 10;
			number /= 10;
		}
		System.out.println(result);
		
	}

}