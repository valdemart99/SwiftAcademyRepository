package Task2_UniversityManagement;

import java.util.*;

public class Task2_UniversityManagement {

	private static void determineCommand(String command, University university) {
		String[] input = command.split(" ");
		
		switch (input[0]) {
			case "NEW": // execute NEW command, use the switch to call the correct constructor				
				newEntry(input, university);
				break;
				
			case "WORK": 
				university.getPersonList()[university.getPersonIndex(input[1])].personWorks(university);
				toleranceLoop(university, university.getPersonList()[university.getPersonIndex(input[1])]);
				break;
				
			case "IDLE": 
				toleranceLoop(university, null);
				break;
		}
	}
	
	private static void toleranceLoop(University university, UniversityPerson person) {
		
		for (int i = 0; i < university.getPersonList().length; ++i) {
			if (university.getPersonList()[i] == null) {
				break;
			} else {
				university.getPersonList()[i].adjustTolerance(person);
			}
		}
	}
	
	private static String[] getSubjects(String[] input, int personType) {
		
		int listCounter = (personType == 3 ? 5 : 4);
		
		if (input.length - listCounter > 0 ) {
			String[] resultList = new String[input.length - listCounter];
			
			for (int i = 0; i < resultList.length; ++i) {
				resultList[i] = input[i + listCounter];
			}
			return resultList;
		} else {
			return new String[0];
		}
	}
	
	private static void newEntry(String[] input, University university) {
		switch(input[1]) {
			case "MAINT": 
				university.addPersonEntry(new MaintenanceEmployee(input[2], input[3]));
				break;
			case "ADMIN":
				university.addPersonEntry(new AdministrationEmployee(input[2], input[3], getSubjects(input, 1)));
				break;
			case "TEACH": 
				university.addPersonEntry(new Teacher(input[2], input[3], getSubjects(input, 2)));
				break;
			case "STUDENT": 
				university.addPersonEntry(new Student(input[2], input[3], input[4], getSubjects(input, 3)));
				break;
		}
	}

	private static void closingProcedure(University university) {
		if (university.getBalance() <= 0) {
			System.out.println("Bankrupcy");
			
		} else if (university.checkTolerance() >= 0) {
			System.out.printf("%s is not happy.\n", university.getPersonList()[university.checkTolerance()].getName());
			
		} else {
			for (int i = 0; i < university.getPersonList().length; ++i) {
				if (university.getPersonList()[i] != null) {
					System.out.printf("%s tolerance: %d\n",
							university.getPersonList()[i].getName(),
							university.getPersonList()[i].getTolerance());
				} else {
					break;
				}
			}
			System.out.println("Balance: " + university.getBalance());
		}
	}
	
	public static void main(String[] args) {
		
		University university = new University();
		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();
		
		while (!command.equals("END")) {
			determineCommand(command, university);
			command = sc.nextLine();
		}
		
		sc.close();
		
		closingProcedure(university);
	}
}
