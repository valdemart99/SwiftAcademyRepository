import java.util.Scanner;

public class Task4c_PrintEverySentence {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();
		boolean intervalFix = false;
		
		char[] input = line.toCharArray();
		for (char c : input) {
			System.out.print(c);
			if (c != '.' & c != '!' && c != '?' ) {
				if (intervalFix == true && c == ' ') {
					System.out.println();
					intervalFix = false;
				}
			} else {
				intervalFix = true;
			}

		}

	}

}