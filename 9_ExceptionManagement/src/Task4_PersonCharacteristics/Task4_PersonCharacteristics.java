package Task4_PersonCharacteristics;

import java.time.format.*;
import java.time.*;
import java.util.*;

import Task4_PersonCharacteristics.education.*;
import Task4_PersonCharacteristics.exceptions.IncorrectUserInputException;
import Task4_PersonCharacteristics.input.*;

public class Task4_PersonCharacteristics {
	
	private static PersonChar getPersonEntry(UserInput input) throws Exception {
		Education personEducaiton;
		Address address;
		
		switch(input.getEducationDegree()) {
			case 'P':
				personEducaiton = new PrimaryEducation(input.getEnrollmentDate(),input.getGraduationDate(),
														input.getInstitutionName());
				break;
			case 'S':
				if (input.getFinalGrade() == -1) {
					personEducaiton = new SecondaryEducation(input.getEnrollmentDate(),input.getGraduationDate(),
															input.getInstitutionName());
				} else {
					personEducaiton = new SecondaryEducation(input.getEnrollmentDate(),input.getGraduationDate(),
															input.getInstitutionName(),input.getFinalGrade());
				}
				break;
			case 'B': case 'M': case 'D':
				if (input.getFinalGrade() == -1) {
					personEducaiton = new HigherEducation(input.getEnrollmentDate(),input.getGraduationDate(),
															input.getInstitutionName(),input.getEducationDegree());
				} else {
					personEducaiton = new HigherEducation(input.getEnrollmentDate(),input.getGraduationDate(),
							input.getInstitutionName(),input.getEducationDegree(),input.getFinalGrade());
				}
				break;
			default:
				throw new IncorrectUserInputException("Unrecognized education code.");
		}
		
		if (input.getFloor() == -1 || input.getApartmentNo() == -1) {
			address = new Address(input.getCountry(),input.getCity(), input.getMunicipality(), input.getPostalCode(),
									input.getStreet(), input.getNumber());
		} else {
			address = new Address(input.getCountry(),input.getCity(), input.getMunicipality(), input.getPostalCode(),
					input.getStreet(), input.getNumber(),input.getFloor(), input.getApartmentNo());
		}
		
		return new PersonChar(input.getFirstName(),input.getMiddleName(),input.getLastName(),
				input.getGender(),input.getBirthDate(), input.getHeight(), address,	personEducaiton);
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter how many persons' data will be processed: ");
		int count = sc.nextInt();
		sc.nextLine();
		PersonChar[] list = new PersonChar[count];
		
		int currentLoop = 0;
		while (currentLoop < count) {
			try {
				UserInput input = new UserInput(sc.nextLine());
				list[currentLoop] = getPersonEntry(input);
				currentLoop++;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		sc.close();
		
		for (PersonChar currentPerson: list) {
			System.out.println(currentPerson.toString());
		}
		
	}
}

