package Task3_Bank_Management;

public class Account {
	private String _name;
	private String _govId;
	private double _balance = 0;
	private Credentials _userCredentials;
	
	public Account(String name, String govId, String username, String password) {
		_name = name;
		_govId = govId;
		_userCredentials = new Credentials(username, password);
	}
	
	void deposit(double amount) {
		_balance += amount;
	}
	
	void withdraw(double amount) {
		_balance -= amount;
	}

	public double get_balance() {
		return _balance;
	}
	
	boolean hasAccess(String password) {
		return _userCredentials.checkCurrentPassword(password);
	}
	
	String getUsername() {
		return _userCredentials.getUsername();
	}
	
	String get_govId() {
		return _govId;
	}
	
	String get_name() {
		return _name;
	}
}
