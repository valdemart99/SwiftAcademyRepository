import java.util.Scanner;

public class Task5_PersonCharacteristics {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter how many persons data will be processed: ");
		int number = sc.nextInt();
		sc.nextLine();
		String resultToDisplay = "";
		String first_name = ""; String last_name = ""; String profession = "";
		short birth_year = 0; float weight = 0.f; short height = 0;
		
		// Better way to do this would be to use a single variable to catch input strings
		// For strings we can check if they contain only symbols from 'a'- 'z' and 'A' - 'Z' and if their length is >0
		// For numbers we can use 
		//		while (true) {
		//			String input = sc.nextLine();
		//			try {number = Integer.parseInt(input); }
		//			catch (NumberFormatException e){continue; }
		// 			if (number >0 && number < upperValue) { 
		//				break;
		//			} else {
		//				continue;
		//			}
		//		}
		// This will allow us to use a single variable and check it for each input but will make the code even longer.
		// I will improve the code upon getting to Error Handling
		
		for (int i = 1; i <= number; i++) {
			System.out.println("Data input for person number " + i);
			System.out.print("Enter first name: ");
			while (true) {
				first_name = sc.nextLine();
				if (first_name.length()>0) {
					break;
				} else {
					System.out.println("Please enter first name!");
				}
			}
			
			System.out.print("Enter last name: ");
			while (true) {
				last_name = sc.nextLine();
				if (last_name.length()>0) {
					break;
				} else {
					System.out.println("Please enter last name!");
				}
			}

			System.out.print("Enter birth year (whole positive number): ");
			while (true) {
				birth_year = sc.nextShort();
				if (birth_year >= 1900 && birth_year <= 2019) {
					break;
				} else {
					System.out.println("Incorrect year, please try again (enter a whole number between 1900 and 2019!");
				}
			}
			
			System.out.print("Enter weight (i.e. 50.52): ");
			while (true) {
				weight = sc.nextFloat();
				if (weight > 0 && weight < 1000) {
					break;
				} else {
					System.out.println("Incorrect weight input, please try again!");
				}
			}

			System.out.print("Enter height (whole positive number): ");
			while (true) {
				height = sc.nextShort();
				if (height > 0 && height < 300) {
					break;
				} else {
					System.out.println("Incorrect height input, please try again!");
				}
			}
			
			sc.nextLine(); // Why is this necessary to get the next String?
			
			System.out.print("Enter profession: ");
			while (true) {
				profession = sc.nextLine();
				if (profession.length()>0) {
					break;
				} else {
					System.out.println("Please enter profession!");
				}
			}
			
			resultToDisplay += String.format("%s %s is %d years old. He was born in %d. His weight is %.6f and he is %d cm tall. He is a %s.", 
					first_name, last_name, (2019 - birth_year), birth_year, weight, height, profession);
			
			if (2019 - birth_year < 18) {
				resultToDisplay += String.format(" %s %s is under-aged.", first_name, last_name);
			}
			
			resultToDisplay += "\n";
			
		}
		
		sc.close();		
		System.out.print(resultToDisplay);
	}

}