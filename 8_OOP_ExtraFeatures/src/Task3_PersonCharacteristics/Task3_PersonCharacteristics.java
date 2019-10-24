package Task3_PersonCharacteristics;

import java.time.format.*;
import java.time.*;
import java.util.*;

import Task3_PersonCharacteristics.education.*;

public class Task3_PersonCharacteristics {
	
	private static PersonChar getPersonEntry(String[] input) {
		Education personEducaiton;
		Address address;
		
		switch(input[14].charAt(0)) {
			case 'P':
				personEducaiton = new PrimaryEducation(LocalDate.parse(input[16], DateTimeFormatter.ofPattern("d.M.yyyy")),
						LocalDate.parse(input[17], DateTimeFormatter.ofPattern("d.M.yyyy")),
						input[15]);
				break;
			case 'S':
				if (input.length == 19) {
					personEducaiton = new SecondaryEducation(LocalDate.parse(input[16], DateTimeFormatter.ofPattern("d.M.yyyy")),
							LocalDate.parse(input[17], DateTimeFormatter.ofPattern("d.M.yyyy")),
							input[15],
							Float.parseFloat(input[18]));
				} else {
					personEducaiton = new SecondaryEducation(LocalDate.parse(input[16], DateTimeFormatter.ofPattern("d.M.yyyy")),
							LocalDate.parse(input[17], DateTimeFormatter.ofPattern("d.M.yyyy")),
							input[15]);
				}
				break;
			case 'B': case 'M': case 'D':
				if (input.length == 19) {
					personEducaiton = new HigherEducation(LocalDate.parse(input[16], DateTimeFormatter.ofPattern("d.M.yyyy")),
							LocalDate.parse(input[17], DateTimeFormatter.ofPattern("d.M.yyyy")),
							input[15],
							input[14].charAt(0),
							Float.parseFloat(input[18]));
				} else {
					personEducaiton = new HigherEducation(LocalDate.parse(input[16], DateTimeFormatter.ofPattern("d.M.yyyy")),
							LocalDate.parse(input[17], DateTimeFormatter.ofPattern("d.M.yyyy")),
							input[15],
							input[14].charAt(0));
				}
				break;
			default:
				personEducaiton = new PrimaryEducation(LocalDate.now(), LocalDate.now(), "");
		}
		
		if (input[12].equals("") || input[13].equals("")) {
			address = new Address(input[6],
					input[7],
					input[8],
					Short.parseShort(input[9]),
					input[10],
					Short.parseShort(input[11]));
		} else {
			address = new Address(input[6],
					input[7],
					input[8],
					Short.parseShort(input[9]),
					input[10],
					Short.parseShort(input[11]),
					Short.parseShort(input[12]),
					Short.parseShort(input[13]));
		}
		
		return new PersonChar(input[0],
				input[1],
				input[2],
				input[3].charAt(0),
				LocalDate.parse(input[4], DateTimeFormatter.ofPattern("d.M.yyyy")),
				Short.parseShort(input[5]),
				address,
				personEducaiton);
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
			System.out.println(currentPerson.toString());
		}
		
	}
}

