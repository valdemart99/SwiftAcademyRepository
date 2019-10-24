package Task2_Bank;

import java.util.*;

public class Task2_Bank {
	
	public static boolean parseCommands(Bank bank, String command) {
		String[] input = command.split(" ");
		
		switch (input[0]) {
			case "OPEN":
				bank.openAccount(input); break;
			case "PUT":
				bank.depositAmount(input); break;
			case "GET":
				bank.creditAmount(input); break;
			case "INFO":
				bank.getInfo(input); break;
			case "END":
				return false;
			default:
		}
		return true;
	}
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		Scanner sc = new Scanner(System.in);
		
		while (parseCommands(bank, sc.nextLine())) {}
		
		sc.close();
	}	
}
