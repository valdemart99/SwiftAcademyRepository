
import java.util.Scanner;

public class Task3c_CaesarCipher {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		String command = input.nextLine();
		input.close();
		
		int code = 0;
		if (command.equals("encode")) {
			code = 1;
		} else if (command.equals("decode")) {
			code = -1;
		}

		char[] text = inputString.toCharArray();
				
		StringBuilder result = new StringBuilder("");
		for (char letter: text) {
			char tempChar;
			if ((letter == 'z' || letter == 'Z') && code == 1) {
				tempChar = (char) (letter - 25);
			} else if ((letter == 'a' || letter == 'A') && code == -1) {
				tempChar = (char) (letter + 25);
			} else if ((letter >='a' && letter <= 'z') || (letter >='A' && letter <= 'Z')) {
				tempChar = (char) (letter + code);
			} else {
				tempChar = letter;
			}
			result.append(tempChar);
		}
		
		System.out.println(result);

	}

}
