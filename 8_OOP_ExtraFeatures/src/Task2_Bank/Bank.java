package Task2_Bank;

import java.util.*;
import Task2_Bank.accounts.*;
import Task2_Bank.customers.*;

public class Bank {
	private List<Account> accounts;
	
	public Bank() {
		this.accounts = new ArrayList<>();
	}
	
	public void openAccount(String[] userInput) {
		if (checkAccountInput(userInput)) {
			createAccountByType(userInput);
			System.out.println(this.accounts.get(this.accounts.size()- 1).getIban());
		}
	}
	
	public void depositAmount(String[] userInput) {
		try {
			this.getAccountByNameIban(userInput[1]).depositAmount(Double.parseDouble(userInput[2]));
		} catch (IllegalArgumentException e) {}
	}
	
	public void creditAmount(String[] userInput) {
		try {
			Account temp = this.getAccountByNameIban(userInput[1]);
			if(temp instanceof DepositAccount) {
				((DepositAccount) temp).creditAmount(Double.parseDouble(userInput[2]));
			}
		} catch (IllegalArgumentException e) {}
	}
	
	public void getInfo(String[] userInput) {
		try {
			System.out.printf("%.2f\n" ,this.getAccountByNameIban(userInput[1]).calculateInterestByPeriod(Integer.parseInt(userInput[2])));
		} catch (IllegalArgumentException e) {}
	}
	
	private boolean checkAccountInput(String[] userInput) {
		try {
			if (userInput.length == 6 &&
				userInput[1].length() > 0 &&
				Integer.parseInt(userInput[2]) >= 1 &&
				Integer.parseInt(userInput[2]) <= 2 &&
				Integer.parseInt(userInput[3]) >= 1 &&
				Integer.parseInt(userInput[3]) <= 3 &&
				Double.parseDouble(userInput[4]) >= 0 &&
				Double.parseDouble(userInput[5]) >= 0) {
				return true;
			} else {
				return false;
			}
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
	
	private Customer getUserType(String[] userInput) {		
		switch(userInput[2]) {
			case "1":
				return new IndividualCustomer(userInput[1]);
			case "2":
				return new CompanyCustomer(userInput[1]);
			default:
				return new IndividualCustomer("");
		}
	}
	
	private void createAccountByType(String[] userInput) {
		switch (userInput[3]) {
		case "1":
			this.accounts.add(new DepositAccount(getUserType(userInput), Double.parseDouble(userInput[4]), Double.parseDouble(userInput[5])));
			break;
		case "2":
			this.accounts.add(new LoanAccount(getUserType(userInput), Double.parseDouble(userInput[4]), Double.parseDouble(userInput[5])));
			break;
		case "3":
			this.accounts.add(new MortgageAccount(getUserType(userInput), Double.parseDouble(userInput[4]), Double.parseDouble(userInput[5])));
		}
	}
	
	private Account getAccountByNameIban(String criteria) {
		for (Account currentAccount: this.accounts) {
			if (currentAccount.getOwner().getName().equals(criteria) || currentAccount.getIban().equals(criteria)) {
				return currentAccount;
			}
		}
		return null;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
