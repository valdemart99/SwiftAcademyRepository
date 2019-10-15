package Task4_Market;

public class Person {
	private String _name;
	private double _balance;
	private Product[] _products;
	
	public Person(String name, double balance) {
		this._name = name;
		this._balance = balance;
		this._products = new Product[1000];
	}
	
	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public double get_balance() {
		return _balance;
	}

	public void set_balance(double _balance) {
		this._balance = _balance;
	}

	public Product[] get_products() {
		return _products;
	}

	public void set_products(Product[] _products) {
		this._products = _products;
	}
	
}
