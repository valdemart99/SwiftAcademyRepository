package Task3_Bank_Management;

import java.util.Scanner;

public class Task3_BankManagement {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Bank bank = new Bank();
		String command = input.nextLine();
		
		while (!command.equals("END")) {
			String[] tempArr = command.split(" ");
			
			if (tempArr[0].equals("OPEN")) {
				bank.openAccount(tempArr[3], tempArr[4], tempArr[1], tempArr[2]);
			} else if (tempArr[0].equals("CLOSE")) {
				bank.closeAccount(tempArr[1], tempArr[2]);
			} else if (tempArr[0].equals("DEPOSIT")) {
				bank.deposit(tempArr[1], Double.valueOf(tempArr[2]));
			} else if (tempArr[0].equals("WITHDRAW")) {
				bank.withdraw(tempArr[1], tempArr[2], Double.valueOf(tempArr[3]));
			} else if (tempArr[0].equals("TRANSFER")) {
				bank.transfer(tempArr[1], tempArr[2], Double.valueOf(tempArr[3]), tempArr[4]);
			}
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
