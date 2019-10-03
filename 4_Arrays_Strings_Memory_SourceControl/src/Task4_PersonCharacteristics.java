
import java.util.*;

public class Task4_PersonCharacteristics {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter how many persons data will be processed: ");
		int number = sc.nextInt();
		sc.nextLine();
		
		StringBuilder result = new StringBuilder();
		
		for (int i = 1; i <= number; i++) {
			String[] currentInput = sc.nextLine().split(";");
			String firstName = currentInput[0];
			String lastName = currentInput[1];
			char gender = currentInput[2].charAt(0);
			short birth_year = Short.valueOf(currentInput[3]);
			float weight = Float.valueOf(currentInput[4]);
			short height = Short.valueOf(currentInput[5]);
			String profession = currentInput[6];
			float[] marks = { Float.valueOf(currentInput[7]), Float.valueOf(currentInput[8]),
					Float.valueOf(currentInput[9]), Float.valueOf(currentInput[10]) };
			float avgMark = 0;
			
			for (float x: marks) {
				avgMark += x;
			}
			avgMark /= marks.length;
			
			result.append(firstName).append(" ").append(lastName).
						append(" is ").append(2019 - birth_year).append(" years old. ").
						append(gender == 'M' ? "His weight is " : "Her weight is ").
						append(weight).append(gender == 'M' ? " and he is " : " and she is ").
						append(height).append(" cm tall. ").append(gender == 'M' ? "He is a " : "She is a ").
						append(profession).append(" with an average grade of ").append(avgMark).append(". ");
			
			if (2019 - birth_year < 18) {
				result.append(firstName).append(" ").append(lastName).append(" is under-aged.");
			}
			
			result.append("\n");
			
		}
		
		System.out.println(result);
	}

}
