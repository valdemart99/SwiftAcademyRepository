import java.util.Scanner;

public class Task4b_PrintCountOfWords {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();
		int wordCount = 0;
		boolean wordCheck = false;
		
		char[] input = line.toCharArray();
		// The below logic is a simplification for the given conditions. A lot more conditions can be added to modify what is a word
		for (char c : input) {
			if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || c == 39 || c == 8217) {
				if (wordCheck == false) {
					wordCheck = true;
					wordCount++;
				}
			} else if (c == ' ' || c == '.' || c == '!' || c == '?') {
				if (wordCheck == true) {
					wordCheck = false;
				}
			} else { 
				if (wordCheck == true) {
					wordCount--;
				}
			}
		}
		
		System.out.println(wordCount);
	}

}