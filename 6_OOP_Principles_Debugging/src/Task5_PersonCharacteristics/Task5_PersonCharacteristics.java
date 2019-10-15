package Task5_PersonCharacteristics;

import java.time.format.*;
import java.time.*;
import java.util.Scanner;

public class Task5_PersonCharacteristics {
	public static void main(String[] args) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.M.yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter how many persons data will be processed: ");
		int count = sc.nextInt();
		sc.nextLine();
		PersonChar[] list = new PersonChar[count];
		
		for (int i = 0; i < count; ++i) {
			String[] tempArr = sc.nextLine().split(";");
			
			if (tempArr.length == 8) {
				list[i] = new PersonChar(tempArr[0], tempArr[1], tempArr[2].charAt(0), LocalDate.parse(tempArr[4], dtf),Short.valueOf(tempArr[3]),
						new SecondaryEducation(LocalDate.parse(tempArr[6], dtf), LocalDate.parse(tempArr[7], dtf), 
							tempArr[5]));
			} else {
				list[i] = new PersonChar(tempArr[0], tempArr[1], tempArr[2].charAt(0), LocalDate.parse(tempArr[4], dtf),Short.valueOf(tempArr[3]),
						new SecondaryEducation(LocalDate.parse(tempArr[6], dtf), LocalDate.parse(tempArr[7], dtf), 
							tempArr[5], Double.valueOf(tempArr[8])));
			}
		}
		
		sc.close();
		
		for (int j = 0; j < count; ++j) {
			System.out.printf("%s %s is %d years old. %s was born in %d. %s weight is %.1f and %s is %d tall. "
					+ "%s is a %s with an average grade of %.3f.", list[j].getFirstName(),
					list[j].getLastName(),  list[j].getGender() == 'M' ? "He": "She",
					list[j].getBirth_date(), list[j].getGender() == 'M' ? "His": "Her",
					list[j].getGender() == 'M' ? "he": "she", list[j].getHeight(),
					list[j].getGender() == 'M' ? "He": "She");
			
			if (2019 < 18) {
				System.out.printf(" %s %s is under-aged.", list[j].getFirstName(), list[j].getLastName());
			}
			System.out.println();
		}
		
	}
}
