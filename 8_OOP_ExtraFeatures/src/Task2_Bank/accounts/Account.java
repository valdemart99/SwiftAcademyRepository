package Task2_Bank.accounts;

import Task2_Bank.customers.*;

public abstract class Account {
	private String iban;
	private Customer owner;
	private double balance;
	private double monthlyInterestRate;
	
	public Account(String iban, Customer owner, double monthlyInterestRate) {
		this.iban = iban;
		this.owner = owner;
		this.balance = 0;
		this.monthlyInterestRate = monthlyInterestRate;
	}
	
	public void depositAmount(double amount) {
		if (amount > 0 ) {
			this.balance += amount;
		}
	}
	
	protected double calculateInterest(int months) {
		return this.balance * this.monthlyInterestRate * months;
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
