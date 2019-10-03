import java.util.Scanner;

public class Task3a_IsPalindrome {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);		
		char[] text = input.nextLine().toCharArray();
		
		input.close();
		boolean palindromCheck = true;
		
		for (int i = 0; i < text.length; ++i) {
			if (text[i] != text[text.length -1 -i]) {
				palindromCheck = false;
			}
		}
		
		System.out.println(palindromCheck);

	}

}
