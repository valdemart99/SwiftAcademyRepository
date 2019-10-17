package Task5_PersonCharacteristics;

import java.time.format.*;
import java.time.*;
import java.util.Scanner;

public class Task5_PersonCharacteristics {
	
	private static PersonChar getPersonEntry(String[] input) {
		
		if (input.length == 8) {
			return new PersonChar(input[0],
								input[1],
								input[2].charAt(0),
								LocalDate.parse(input[4], DateTimeFormatter.ofPattern("d.M.yyyy")),
								Short.valueOf(input[3]),
						new SecondaryEducation(LocalDate.parse(input[6], DateTimeFormatter.ofPattern("d.M.yyyy")),
												LocalDate.parse(input[7], DateTimeFormatter.ofPattern("d.M.yyyy")), 
												input[5]));
		} else {
			return new PersonChar(input[0],
								input[1],
								input[2].charAt(0),
								LocalDate.parse(input[4], DateTimeFormatter.ofPattern("d.M.yyyy")),
								Short.valueOf(input[3]),
						new SecondaryEducation(LocalDate.parse(input[6], DateTimeFormatter.ofPattern("d.M.yyyy")),
												LocalDate.parse(input[7], DateTimeFormatter.ofPattern("d.M.yyyy")), 
												input[5],
												Double.valueOf(input[8])));
		}
	}
	
	private static void printResult(PersonChar person) {
		
		System.out.printf("%s %s is %d years old. %s was born in %d. %s started %s on %s and ",
				person.getFirstName(),
				person.getLastName(),
				(2019 - person.getBirth_date().getYear()),
				person.getGender() == 'M' ? "He": "She",
				person.getBirth_date().getYear(),
				person.getGender() == 'M' ? "He": "She",
				person.getSecEducation().getInstitutionName(),
				person.getSecEducation().getEnrollmentDate()).toString();
		
		if (person.getSecEducation().isGraduate()) {
			
			System.out.printf("finished on %s with a grade of %.3f.",
				person.getSecEducation().getGraduationDate().toString(),
				person.getSecEducation().getFinalGrade());
		} else {
			
			System.out.printf("is supposed to graduate on %s.",
				person.getSecEducation().getGraduationDate().toString());
		}
		
		if (2019 - person.getBirth_date().getYear() < 18) {
			System.out.printf(" %s %s is under-aged.",
				person.getFirstName(),
				person.getLastName());
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter how many persons data will be processed: ");
		int count = sc.nextInt();
		PersonChar[] list = new PersonChar[count];
		sc.nextLine();
		
		for (int i = 0; i < count; ++i) {
			list[i] = getPersonEntry(sc.nextLine().split(";"));
		}
		
		sc.close();
		
		for (PersonChar currentPerson: list) {
			printResult(currentPerson);
		}
		
	}
}
