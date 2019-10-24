package Task1_NumberNotANumber;

import java.util.*;

public class Task1_Number_NotANumber {

	public static boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String command = scan.nextLine();
		
		while(!command.equals("END")) {
			System.out.println(isNumber(command) ? "Number" : "Not a number");
			command = scan.nextLine();
		}
		scan.close();
	}
}
