package Task2_UniversityManagement;

import java.util.*;

public class Task2_UniversityManagement {

	private static int getCommand(String command) {
		String[] commandList = { "NEW", "WORK", "IDLE"};
		for (int i = 0; i < commandList.length; ++i) {
			if (commandList[i].equals(command)) { return i; }
		}
		return -1;
	}
	
	private static int getPersonType(String type) {
		if (type.equals("MAINT")) { return 0; }
		else if (type.equals("ADMIN")) { return 1; }
		else if (type.equals("TEACH")) { return 2; }
		else { return 3; } // STUDENT
	}
	
	private static String[] getSubjects(String[] input, int personType) {
		
		int listCounter = (personType == 3 ? 5 : 4);
		int subjectsCount = input.length - listCounter;
		
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
	
	private static void determineCommand(String command, University university) {
		String[] input = command.split(" ");
		
		switch (getCommand(input[0])) {
			case 0: // execute NEW command, use the switch to call the correct constructor				
				newEntry(input, university);
				break;
				
			case 1: 
				int index = university.getPersonIndex(input[1]);
				
				if (university.getPersonList()[index] instanceof Student) {
					((Student) university.getPersonList()[index]).personWorks(university);
				} else {
					((Employee) university.getPersonList()[index]).personWorks(university);
				}
				
				toleranceLoop(university, university.getPersonList()[index]);
				break;
			case 2: 
				toleranceLoop(university, null);
				break;
		}
		
	}
	
	private static void newEntry(String[] input, University university) {
		switch(getPersonType(input[1])) {
			case 0: 
				university.addPersonEntry(new MaintenanceEmployee(input[2], input[3]));
				break;
			case 1:
				university.addPersonEntry(new AdministrationEmployee(input[2], input[3], getSubjects(input, 1)));
				break;
			case 2: 
				university.addPersonEntry(new Teacher(input[2], input[3], getSubjects(input, 2)));
				break;
			case 3: 
				university.addPersonEntry(new Student(input[2], input[3], input[4], getSubjects(input, 3)));
				break;
		}
	}
	
	private static void toleranceLoop(University university, UniversityPerson person) {
		
		for (int i = 0; i < university.getPersonList().length; ++i) {
			if (university.getPersonList()[i] instanceof Student) {
				((Student) university.getPersonList()[i]).adjustTolerance(person);
			} else if (university.getPersonList()[i] instanceof Teacher) {
				((Teacher) university.getPersonList()[i]).adjustTolerance(person);
			} else if (university.getPersonList()[i] instanceof AdministrationEmployee) {
				((AdministrationEmployee) university.getPersonList()[i]).adjustTolerance(person);
			} else if (university.getPersonList()[i] instanceof MaintenanceEmployee) {
				((MaintenanceEmployee) university.getPersonList()[i]).adjustTolerance(person);
			} else {
				break;
			}
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
