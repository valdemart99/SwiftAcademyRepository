import java.util.Scanner;

public class Task4d_SumOfNumbersInString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();
		int sum = 0;
		String tempNumber = "";
		boolean numberCheck = false;
		
		char[] input = line.toCharArray();
		for (char c : input) {
			if ( c >= '0' && c <= '9') {
				numberCheck = true;
				tempNumber += c;
			} else if ( numberCheck ) {
				numberCheck = false;
				sum += Integer.parseInt(tempNumber);
				tempNumber = "";
			} else if (c == '-') {
				// Added to capture any negative numbers
				numberCheck = true;
				tempNumber += c;
			}
		}
		
		// When the last symbol of the string is also a number we need to make additional check or we will miss it
		// The loop has no way to identify that a number is finished if it is the last symbol 
		if (numberCheck) { sum += Integer.parseInt(tempNumber); }
		
		System.out.println(sum);
	}

}