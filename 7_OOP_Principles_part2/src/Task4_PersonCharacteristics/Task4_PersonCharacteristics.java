package Task4_PersonCharacteristics;

import java.time.format.*;
import java.time.*;
import java.util.*;

import Task4_PersonCharacteristics.education.*;

public class Task4_PersonCharacteristics {
	
	private static PersonChar getPersonEntry(String[] input) {
		Education personEducaiton;
		
		switch(input[5].charAt(0)) {
			case 'P':
				personEducaiton = new PrimaryEducation(LocalDate.parse(input[7], DateTimeFormatter.ofPattern("d.M.yyyy")),
						LocalDate.parse(input[8], DateTimeFormatter.ofPattern("d.M.yyyy")), input[6]);
				break;
			case 'S':
				if (input.length == 10) {
					personEducaiton = new SecondaryEducation(LocalDate.parse(input[7], DateTimeFormatter.ofPattern("d.M.yyyy")),
															LocalDate.parse(input[8], DateTimeFormatter.ofPattern("d.M.yyyy")),
															input[6],
															Float.parseFloat(input[9]));
				} else {
					personEducaiton = new SecondaryEducation(LocalDate.parse(input[7], DateTimeFormatter.ofPattern("d.M.yyyy")),
															LocalDate.parse(input[8], DateTimeFormatter.ofPattern("d.M.yyyy")),
															input[6]);
				}
				
				break;
			case 'B': case 'M': case 'D':
				if (input.length == 10) {
					personEducaiton = new HigherEducation(LocalDate.parse(input[7], DateTimeFormatter.ofPattern("d.M.yyyy")),
															LocalDate.parse(input[8], DateTimeFormatter.ofPattern("d.M.yyyy")),
															input[6],
															input[5].charAt(0),
															Float.parseFloat(input[9]));
				} else {
					personEducaiton = new HigherEducation(LocalDate.parse(input[7], DateTimeFormatter.ofPattern("d.M.yyyy")),
															LocalDate.parse(input[8], DateTimeFormatter.ofPattern("d.M.yyyy")),
															input[6],
															input[5].charAt(0));
				}
				
				break;
			default:
				personEducaiton = new PrimaryEducation(LocalDate.now(), LocalDate.now(), "");
		}
		
		return new PersonChar(input[0], input[1], input[2].charAt(0),
				LocalDate.parse(input[4], DateTimeFormatter.ofPattern("d.M.yyyy")),
				Short.valueOf(input[3]),
				personEducaiton);
	}
	
	private static void printResult(PersonChar person) {
		
		System.out.printf("%s %s is %d years old. %s was born in %d. %s started %s degree in %s on %s and %s on %s.",
				person.getFirstName(),
				person.getLastName(),
				(2019 - person.getBirth_date().getYear()),
				person.getGender() == 'M' ? "He": "She",
				person.getBirth_date().getYear(),
				person.getGender() == 'M' ? "He": "She",
				person.getEducation().getDegree(),
				person.getEducation().getInstitutionName(),
				person.getEducation().getEnrollmentDate().toString(),
				person.getEducation().getGraduationDate().isBefore(LocalDate.now()) ? "finished" : "is supposed to graduate",
				person.getEducation().getGraduationDate().toString());
		
		if (person.getEducation() instanceof GradedEducation && person.getEducation().getGraduationDate().isBefore(LocalDate.now())) {
			System.out.printf(" %s grade was %.3f",
				person.getGender() == 'M' ? "His" : "Her",
				((GradedEducation)person.getEducation()).getFinalGrade());
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

