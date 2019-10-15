package Task3_Bank_Management;

import java.util.Scanner;

public class Task3_BankManagement {
	
	public static int getCommand(String command) {
		String[] commandList = { "OPEN", "CLOSE", "DEPOSIT", "WITHDRAW", "TRANSFER" };
		for (int i = 0; i < commandList.length; ++i) {
			if (commandList[i].equals(command)) 
				{ return i; }
		}
		return -1;
	}
	
	public static void commandProcess(String command, Bank bank) {
		String[] tempArr = command.split(" ");
		
		switch (getCommand(tempArr[0])) {
			case 0:
				bank.openAccount(tempArr[3], tempArr[4], tempArr[1], tempArr[2]); break;
			case 1:
				bank.closeAccount(tempArr[1], tempArr[2]); break;
			case 2:
				bank.deposit(tempArr[1], Double.valueOf(tempArr[2])); break;
			case 3:
				bank.withdraw(tempArr[1], tempArr[2], Double.valueOf(tempArr[3])); break;
			case 4:
				bank.transfer(tempArr[1], tempArr[2], Double.valueOf(tempArr[3]), tempArr[4]); break;
			default:
		}
	}
	
	public static void main(String[] args) {
		
		Bank bank = new Bank();
		Scanner input = new Scanner(System.in);
		String command = input.nextLine();
		
		while (!command.equals("END")) {
			commandProcess(command, bank);
			command = input.nextLine();
		}
		
		input.close();
		
		System.out.printf("%.2f\n", bank.get_assets());
		
		for (int i = 0; i < bank._accounts.length; ++i) {
			if (bank._accounts[i] != null) {
				System.out.printf("%s, %s, %.2f\n", bank._accounts[i].get_name(),
						bank._accounts[i].get_govId(), bank._accounts[i].get_balance());
			}
		}
	}
}
