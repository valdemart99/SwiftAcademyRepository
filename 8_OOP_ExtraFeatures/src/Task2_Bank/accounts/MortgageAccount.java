package Task2_Bank.accounts;

import Task2_Bank.customers.*;

public class MortgageAccount extends Account {

	public MortgageAccount(String iban, Customer owner, double monthlyInterestRate) {
		super(iban, owner, monthlyInterestRate);
	}

	public double calculateInterestByPeriod(int months) {
		// TODO Auto-generated method stub
		return 0;
	}

}
