import java.util.Scanner;

public class Task0b_ReadArray {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);		
		int[] masiv = new int[input.nextInt()];
		input.nextLine();
		
		for (int i = 0; i < masiv.length; i++) {
			masiv[i] = input.nextInt();
			System.out.print(masiv[i] + (i < masiv.length -1 ? "," : ""));
		}
		
		input.close();

	}

}
