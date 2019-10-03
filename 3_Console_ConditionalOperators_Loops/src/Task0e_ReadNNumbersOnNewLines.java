import java.util.Scanner;

public class Task0e_ReadNNumbersOnNewLines {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		String result = ""; // Will use this string to construct the end result in the required format
		
		for (int i = 1; i <= number; i++) {
			result = result + (i == 1 ? "" : " ") + sc.nextInt();
		}
		
		sc.close();	
		System.out.println(result);
	}

}