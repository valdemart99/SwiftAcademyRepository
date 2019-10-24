package Task2_Bank.accounts;

import Task2_Bank.customers.*;

public class MortgageAccount extends Account {

	public MortgageAccount(Customer owner, double balance, double monthlyInterestRate) {
		super(owner, balance, monthlyInterestRate);
	}

	public double calculateInterestByPeriod(int months) {
		if (this.getOwner() instanceof IndividualCustomer && months > 6) {
			return this.getBalance() * this.getMonthlyInterestRate() * (months - 6);
		} else if (this.getOwner() instanceof CompanyCustomer) {
			if (months > 12) {
				return this.getBalance() * 
						( (this.getMonthlyInterestRate() * 6) +
						(this.getMonthlyInterestRate() * (months - 12)) );
			} else {
				return this.getBalance() * (this.getMonthlyInterestRate() / 2) * months;
			}
		} else {
			return 0;
		}
	}
}
