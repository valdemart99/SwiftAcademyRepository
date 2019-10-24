package Task2_Bank.accounts;

import Task2_Bank.customers.*;

public class DepositAccount extends Account {

	public DepositAccount(Customer owner, double balance, double monthlyInterestRate) {
		super(owner, balance, monthlyInterestRate);
	}
	
	public void creditAmount(double amount) {
		if (amount > 0 && super.getBalance() >= amount) {
			super.setBalance(super.getBalance() - amount);
		}
	}

	public double calculateInterestByPeriod(int months) {
		return this.getBalance() * this.getMonthlyInterestRate() * months;
	}
}
