package Task1_PeoplePresentation;

public class Person {
	private String name;
	private String lastName;
	
	public Person(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

	private static boolean inputLengthCheck(String parameter) {
		if (parameter.length() < 2 || parameter.length() >30) {
			System.out.printf("Expected length for %s is between 2 and 30 symbols.\n", parameter);
			return false;
		}
		return true;
	}
	
	private static boolean inputContentCheck(String parameter) {
		boolean check = true;
		for (Character x: parameter.toCharArray()) {
			if ((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z')) {
				continue;
			} else {
				check = false;
				System.out.printf("Expected only Latin letters in %s.\n", parameter);
				break;
			}
		}
		return check;
	}

	private static boolean inputProperCaseCheck(String parameter) {
		if (parameter.toCharArray()[0] >= 'A' && parameter.toCharArray()[0] <= 'Z') {
			return true;
		} else {
			System.out.printf("Expected upper case letter at first position of %s.\n", parameter);
			return false;
		}
	}
	
	public static boolean inputNameCheck(String input) {
		return inputLengthCheck(input) && inputContentCheck(input) && inputProperCaseCheck(input);
	}
	
	@SuppressWarnings("finally")
	public static boolean checkInputInteger(String input) {
		boolean check = true;
		try {
			Integer.valueOf(input);
		} catch(NumberFormatException e) {
			check = false;
			System.out.printf("Expected integer for %s.\n", input);
		} finally {
			return check;
		}
	}
	
	@SuppressWarnings("finally")
	public static boolean checkInputPositiveNumber(String input) {
		boolean check = true;
		try {
			if (Double.valueOf(input) < 0) {
				check = false;
				System.out.printf("Expected positive number for %s.\n", input);
			}
		} catch(NumberFormatException e) {
			check = false;
			System.out.printf("Expected positive number for %s.\n", input);
		} finally {
			return check;
		}
	}
	
	public static boolean checkHoursCount(String input) {
		return checkInputInteger(input) && checkInputPositiveNumber(input);
	}
	
	public void printNames() {
		System.out.println("First name: " + this.name);
		System.out.println("Last name: " + this.lastName);
		System.out.printf("Occupation: ");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (inputNameCheck(name)) {
			this.name = name;
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (inputNameCheck(lastName)) {
			this.lastName = lastName;
		}
	}
}
