package Task3_Credentials_Manager;

import java.util.*;

public class UserInput {
	Scanner input = new Scanner(System.in);
	private String[] command;
	private static int commandCounter;
	
	public UserInput() {
		this.commandCounter = 0;
	}
	
	public boolean checkCommand() {
		if (command[0].equals("AUTH") || command[0].equals("ENROLL") || command[0].equals("CHPASS")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkInput() {
		if ( (command[0].equals("AUTH") || command[0].equals("ENROLL")) && command.length == 3) {
			return true;
		} else if (command[0].equals("CHPASS") && command.length ==4) {
			return true;
		} else {
			System.out.println(command[0] + " fail");
			return false;
		}
	}
	
	public void setCommand() {
		this.command = input.nextLine().split(" ");
		commandCounter++;
	}
	
	public String[] getCommand() {
		return this.command;
	}
	
	public String getCommandType() {
		return this.command[0];
	}
	
	public int getCommandCounter() {
		return this.commandCounter;
	}
}
