
import java.util.Scanner;

public class Task3e_ConvertibleStrings {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String firstString = input.nextLine();
		String secondString = input.nextLine();
		input.close();
		
		boolean check = false;
		
		outerLoop: // searched for labeling and found that this is the exact use for them in Java
		for (int i = 0 ; i < secondString.length(); i++) {
			for (int k = i; k < firstString.length();k++) {
				if ((firstString.substring(0, i)).
						concat(firstString.substring(k,firstString.length())).
							equals(secondString)) {
					check = true; break outerLoop;
				}
			}
			
		}
		
		System.out.println(check);

	}

}
