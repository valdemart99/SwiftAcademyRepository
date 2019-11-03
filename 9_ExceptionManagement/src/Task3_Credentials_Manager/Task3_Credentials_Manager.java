package Task3_Credentials_Manager;
import java.util.*;

public class Task3_Credentials_Manager {
	
	private static void commandLoop(UserInput userInput, Credentials[] credentials) {
		if (userInput.checkCommand() && userInput.checkInput()) {
			
			switch (userInput.getCommandType()) {
				case "ENROLL":
					credentials[userInput.getCommandCounter()] = new Credentials(userInput.getCommand()[1], userInput.getCommand()[2]);
					break;
				case "AUTH":
					int index = getUserIndex(credentials, userInput.getCommand()[1]);
					if (index > -1) {
						credentials[index].checkCurrentPassword(userInput.getCommand()[2]);
					}
					break;
				case "CHPASS":
					int index2 = getUserIndex(credentials, userInput.getCommand()[1]);
					if (index2 > -1) {
						credentials[index2].setPassword(userInput.getCommand()[2], userInput.getCommand()[3]);
					}
					break;
			}
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
		Credentials[] userList = new Credentials[200];
		UserInput userInput = new UserInput();
		userInput.setCommand();
		
		while (!userInput.getCommandType().equals("END")) {
			commandLoop(userInput, userList);
			userInput.setCommand();
		}

	}
	
}
