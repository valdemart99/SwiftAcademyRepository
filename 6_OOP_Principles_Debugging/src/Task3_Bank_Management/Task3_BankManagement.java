package Task3_Bank_Management;

import java.util.Scanner;

public class Task3_BankManagement {
	
	public static void commandProcess(String command, Bank bank) {
		String[] tempArr = command.split(" ");
		
		switch (tempArr[0]) {
			case "OPEN":
				bank.openAccount(tempArr[3], tempArr[4], tempArr[1], tempArr[2]); break;
			case "CLOSE":
				bank.closeAccount(tempArr[1], tempArr[2]); break;
			case "DEPOSIT":
				bank.deposit(tempArr[1], Double.valueOf(tempArr[2])); break;
			case "WITHDRAW":
				bank.withdraw(tempArr[1], tempArr[2], Double.valueOf(tempArr[3])); break;
			case "TRANSFER":
				bank.transfer(tempArr[1], tempArr[2], Double.valueOf(tempArr[3]), tempArr[4]); break;
			default:
		}
	}
	
	public static void endingProcedure(Bank bank) {
		System.out.printf("%.2f\n", bank.get_assets());
		
		for (int i = 0; i < bank._accounts.length; ++i) {
			if (bank._accounts[i] != null) {
				System.out.printf("%s, %s, %.2f\n", bank._accounts[i].get_name(),
						bank._accounts[i].get_govId(), bank._accounts[i].get_balance());
			}
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
		
		endingProcedure(bank);
	}
}
