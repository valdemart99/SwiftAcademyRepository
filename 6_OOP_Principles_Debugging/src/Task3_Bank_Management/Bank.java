package Task3_Bank_Management;

public class Bank {
	protected Account[] _accounts = new Account[5];
	private double _assets = 0;
	
	public Bank() {	}
	
	void openAccount(String name, String govId, String username, String password) {
		int index = -1;
		// Search for the first available array index to create the new Account object
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
		int index = getUserIndex(username);
		if (_accounts[index].hasAccess(password) &&	_accounts[index].get_balance() == 0) {
			_accounts[index] = null;
			System.out.println("CLOSE success");
		} else {
			System.out.println("CLOSE fail");
		}
	}
	
	void deposit(String username, double amount) {
		int index = getUserIndex(username);
		
		if (index >=0 && amount >= 0) {
			_accounts[index].deposit(amount);
			this._assets += amount;
			System.out.println("DEPOSIT success");
		} else {
			System.out.println("DEPOSIT fail");
		}
	}
	
	void withdraw(String username, String password, double amount) {
		int index = getUserIndex(username);

		if (index >=0 && amount >= 0 && _accounts[index].hasAccess(password) && amount <= _accounts[index].get_balance()) {
			_accounts[index].withdraw(amount);
			this._assets -= amount;
			System.out.println("WITHDRAW success");
		} else {
			System.out.println("WITHDRAW fail");
		}
	}
	
	void transfer(String username, String password, double amount, String recipient) {
		int indexSource = getUserIndex(username);
		int indexRecipient = getUserIndex(recipient);
		
		if (indexSource >= 0 && indexRecipient >= 0 && amount >= 0 && _accounts[indexSource].hasAccess(password)
				&& _accounts[indexSource].get_balance() >= amount) {
			
			_accounts[indexSource].withdraw(amount);
			_accounts[indexRecipient].deposit(amount);
			System.out.println("TRANSFER success");
		} else {
			System.out.println("TRANSFER fail");
		}
	}
	
	private int getUserIndex(String username) {
		int index = -1;
		for (int i = 0; i < _accounts.length; ++i) {
			if (_accounts[i].getUsername().equals(username)) {
				index = i; break;
			}
		}
		return index;
	}
	
	double get_assets() {
		return _assets;
	}
}
