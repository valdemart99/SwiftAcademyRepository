
import java.util.Scanner;

public class Task3f_LongestCommonSubstring {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String firstString = input.nextLine();
		String secondString = input.nextLine();
		input.close();
		
		// Optional part to speed up in case of large strings
		String smallString; String largeString;
		if ( firstString.length() > secondString.length() ) {
			smallString = secondString; largeString = firstString;
		} else {
			smallString = firstString; largeString = secondString;
		}
		
		StringBuilder result = new StringBuilder("");
		
		for (int i = 0; i < smallString.length(); ++i) {
			for (int k = i; k < smallString.length(); ++k) {
				StringBuilder tempStr = new StringBuilder(smallString.substring(i, k));
				if (largeString.contains(tempStr) && tempStr.length() > result.length()) {
					result = tempStr;
				}
			}
		}
		
		System.out.println(result);

	}

}
