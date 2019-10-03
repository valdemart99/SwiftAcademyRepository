import java.util.Scanner;

public class Task0c_PrintString {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);		
		char[] text = input.nextLine().toCharArray();
		
		for (char letter: text) {
			System.out.println(letter);
		}
		
		input.close();

	}

}
