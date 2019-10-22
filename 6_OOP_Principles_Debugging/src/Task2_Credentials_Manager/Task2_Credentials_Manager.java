package Task2_Credentials_Manager;
import java.util.*;

public class Task2_Credentials_Manager {
	
	private static boolean checkCommand(String command) {
		if (command.equals("AUTH") || command.equals("ENROLL") || command.equals("CHPASS")) {
			return true;
		} else {
			return false;
		}
	}
	
	private static boolean checkInput(String[] input) {
		if ( (input[0].equals("AUTH") || input[0].equals("ENROLL")) && input.length == 3) {
			return true;
		} else if (input[0].equals("CHPASS") && input.length ==4) {
			return true;
		} else {
			System.out.println(input[0] + " fail");
			return false;
		}
	}
	
	private static int getUserIndex(Credentials[] userList, String username) {
		int index = -1;
		for (int i = 0; i < userList.length; ++i) {
			if (userList[i] != null && userList[i].getUsername().equals(username)) {
				index = i; break;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Credentials[] userList = new Credentials[200];
		int listCounter = 0;
		String command = input.nextLine();
		
		while (!command.equals("END")) {
			String[] tempArr = command.split(" ");
			
			if (checkCommand(tempArr[0]) && checkInput(tempArr)) {
				
				switch (tempArr[0]) {
					case "ENROLL":
						userList[listCounter] = new Credentials(tempArr[1], tempArr[2]);
						listCounter++; // no check for going over 200, do not wish to complicate it further
						break;
					case "AUTH":
						int index = getUserIndex(userList, tempArr[1]);
						if (index > -1) {
							userList[index].checkCurrentPassword(tempArr[2]);
						}
						break;
					case "CHPASS":
						int index2 = getUserIndex(userList, tempArr[1]);
						if (index2 > -1) {
							userList[index2].setPassword(tempArr[2], tempArr[3]);
						}
						break;
				}

			}
			
			command = input.nextLine();
		}
		
		input.close();
	}
	
}
