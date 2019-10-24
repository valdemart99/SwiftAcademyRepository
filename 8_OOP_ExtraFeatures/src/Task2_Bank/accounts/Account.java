package Task2_Bank.accounts;

import Task2_Bank.customers.*;

public abstract class Account {
	private static int consecutiveIban = 0;
	private String iban;
	private Customer owner;
	private double balance;
	private double monthlyInterestRate;
	
	public Account(Customer owner, double balance, double monthlyInterestRate) {
		this.iban = "00000000".substring(String.valueOf(++consecutiveIban).length()) + String.valueOf(consecutiveIban);
		this.owner = owner;
		this.balance = balance;
		this.monthlyInterestRate = monthlyInterestRate / 100;
	}
	
	public void depositAmount(double amount) {
		if (amount > 0 ) {
			this.balance += amount;
		}
	}

	public abstract double calculateInterestByPeriod(int months);
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getMonthlyInterestRate() {
		return monthlyInterestRate;
	}

	public void setMonthlyInterestRate(double monthlyInterestRate) {
		this.monthlyInterestRate = monthlyInterestRate;
	}

	public String getIban() {
		return iban;
	}

	public Customer getOwner() {
		return owner;
	}
}
