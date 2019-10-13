package Task3_Bank_Management;

public class Bank {
	private static Account[] _accounts = new Account[5];
	private static double _assets = 0;
	
	public Bank() {	}
	
	void openAccount(String name, String govId, String username, String password) {
		int index = -1;
		for (int i = 0; i < _accounts.length; ++i) {
			if (_accounts[i] == null) {
				index = i; break;
			}
		}		
		if (index >= 0) {
			_accounts[index] = new Account(name, govId, username, password);
			System.out.println("OPEN success");
		} else {
			System.out.println("OPEN fail");
		}
	}
	
	void closeAccount(String username, String password) {
		for (int i = 0; i <_accounts.length; ++i) {
			if (_accounts[i].getUsername().equals(username) &&
										_accounts[i].hasAccess(password) &&
										_accounts[i].get_balance() == 0) {
				_accounts[i] = null;
				System.out.println("CLOSE success");
			} else {
				System.out.println("CLOSE fail");
			}
		}
	}
	
	void deposit(String username, double amount) {
		if (amount >= 0) {
			int index = -1;
			for (int i = 0; i < _accounts.length; ++i) {
				if (_accounts[i].getUsername().equals(username)) {
					index = i; break;
				}
			}
			_accounts[index].deposit(amount);
			System.out.println("DEPOSIT success");
		} else {
			System.out.println("DEPOSIT fail");
		}
	}
	
	void withdraw(String username, String password, double amount) {
		
	}
	
	void transfer(String username, String password, double amount, String recipient) {
		
	}
	
	double get_assets() {
		return _assets;
	}
}
