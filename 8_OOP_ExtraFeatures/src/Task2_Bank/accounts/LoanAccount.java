package Task2_Bank.accounts;

import Task2_Bank.customers.*;

public class LoanAccount extends Account {

	public LoanAccount(Customer owner, double balance, double monthlyInterestRate) {
		super(owner, balance, monthlyInterestRate);
	}

	public double calculateInterestByPeriod(int months) {
		if (this.getOwner() instanceof IndividualCustomer && months > 3) {
			return this.getBalance() * this.getMonthlyInterestRate() * (months - 3);
		} else if (this.getOwner() instanceof CompanyCustomer && months > 2) {
			return this.getBalance() * this.getMonthlyInterestRate() * (months - 2);
		} else {
			return 0;
		}
	}

}
