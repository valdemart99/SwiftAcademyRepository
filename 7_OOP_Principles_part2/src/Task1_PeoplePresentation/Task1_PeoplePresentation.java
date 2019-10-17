package Task1_PeoplePresentation;

import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Task1_PeoplePresentation {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();
		boolean properInput = true;
		Person[] personList = new Person[1000];
		int personCounter = 0;
		
		while(!command.equals("END") && properInput) {
			
			String[] input = command.split(" ");
			
			if (input.length == 5) {
				if(Student.checkStudentInput(input[0], input[1], input[2], input[3], input[4])) {
					personList[personCounter++] = new Student(input[0], input[1], input[2],
							Integer.parseInt(input[3]), Integer.parseInt(input[4]));
				} else {
					properInput = false;
				}
			} else {
				if (Worker.checkWorkerInput(input[0], input[1], input[2], input[3])) {
					personList[personCounter++] = new Worker(input[0], input[1],
							Double.parseDouble(input[2]), Double.parseDouble(input[3]));
				} else {
					properInput = false;
				}
			}
			
			if(properInput) {
				command = sc.nextLine();
			}
		}
		
		if(properInput) {
			for (Person currentPerson: personList) {
				if (currentPerson == null) {
					break;
				}
				if (currentPerson instanceof Student) {
					((Student) currentPerson).getInfo();
				} else {
					((Worker) currentPerson).getInfo();
				}
			}
		}
	}
}
