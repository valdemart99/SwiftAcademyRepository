import java.util.Scanner;

public class Task4a_StringWoVowels {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();
		
		char[] input = line.toCharArray();
		for (char c : input) {
			switch (c) {
				case 'a' : case 'e' : case 'i' : case 'o' : case 'u' : case 'y' : break;
				default : System.out.print(c);
			}
		}
	}

}