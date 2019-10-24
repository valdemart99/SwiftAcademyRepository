package Task2_Bank.accounts;

import Task2_Bank.customers.*;

public class DepositAccount extends Account {

	public DepositAccount(String iban, Customer owner, double monthlyInterestRate) {
		super(iban, owner, monthlyInterestRate);
	}
	
	public void creditAmount(double amount) {
		if (amount > 0 && super.getBalance() >= amount) {
			super.setBalance(super.getBalance() - amount);
		}
	}

	public double calculateInterestByPeriod(int months) {
		// TODO Auto-generated method stub
		return 0;
	}

}
