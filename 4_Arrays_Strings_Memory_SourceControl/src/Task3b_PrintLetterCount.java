import java.util.Arrays;
import java.util.Scanner;

public class Task3b_PrintLetterCount {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		inputString = inputString.toLowerCase();
		char[] text = inputString.toCharArray();
		
		input.close();
		Arrays.sort(text);
		
		int charCount = 1;
		
		for (int i = 1; i < text.length;++i) {
			if (text[i] == text[i-1]) {
				charCount++;
				if (i == text.length - 1) {
					System.out.printf("%s(%d)\n", text[i], charCount);
				}
			}  else {
				System.out.printf("%s(%d)\n", text[i-1], charCount);
				charCount = 1;
			}
			
		}

	}

}
