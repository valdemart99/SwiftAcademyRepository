import java.util.Scanner;

public class Task3d_BracketMatching {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		inputString = inputString.toLowerCase();
		char[] text = inputString.toCharArray();
		
		input.close();
		
		boolean check = true;
		char[] tempCharArr = new char[text.length];
		int indexArr = 0;
		
		for (int i = 0; i < text.length;i++) {
			switch( text[i] ) {
				case '(': 
					tempCharArr[indexArr] = 1;
					indexArr++;
					break;
				case '[': 
					tempCharArr[indexArr] = 2;
					indexArr++;
					break;
				case '{': 
					tempCharArr[indexArr] = 3;
					indexArr++;
					break;
				case ')': 
					if (tempCharArr[indexArr -1] == 1) {
						tempCharArr[indexArr -1] = 0;
						indexArr--;
					} else {
						check = false;
					}
					break;
				case ']': 
					if (tempCharArr[indexArr -1] == 2) {
						tempCharArr[indexArr -1] = 0;
						indexArr--;
					} else {
						check = false;
					}
					break;
				case '}': 
					if (tempCharArr[indexArr -1] == 3) {
						tempCharArr[indexArr -1] = 0;
						indexArr--;
					} else {
						check = false;
					}
					break;
				default:
			}
		}
		
		System.out.println(check);

	}

}
