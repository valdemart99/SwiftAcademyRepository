import java.util.Scanner;

public class Task1f_ToBinaryAndHexa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.close();
		String result = "";
		
		// This is the binary part
		for (int tempNumber = number; tempNumber > 0; tempNumber /= 2 ) {
			result = (tempNumber % 2) + result;
		}
		System.out.println(result);
		
		// This is the hex part, we reset the result variable and repeat
		// It is possible there is a class in a library for this, but I go the longer route to exercise the switch operator
		result = "";		
		for (int tempNumber = number; tempNumber > 0; tempNumber /= 16 ) {
			String hexSymbol = "0";
			if (tempNumber % 16 <= 9) {
				hexSymbol = Integer.toString(tempNumber % 16);
			} else {
				switch (tempNumber % 16) {
					case 10: hexSymbol = "A"; break;
					case 11: hexSymbol = "B"; break;
					case 12: hexSymbol = "C"; break;
					case 13: hexSymbol = "D"; break;
					case 14: hexSymbol = "E"; break;
					case 15: hexSymbol = "F"; break;
				}
			}
			result = hexSymbol + result;
			
		}
		System.out.println(result);
		
	}

}