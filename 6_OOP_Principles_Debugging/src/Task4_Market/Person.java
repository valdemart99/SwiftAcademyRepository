package Task4_Market;

public class Person {
	private String _name;
	private double _balance = 0;
	private Product[] _products;
	
	public Person(String name, double balance) {
		this._name = name;
		this._balance = balance;
		this._products = new Product[1000];
	}

	public void addProducts(String product) {
		for (int i = 0; i < _products.length; ++i) {
			if (_products[i] == null) {
				_products[i] = new Product(product);
				break;
			}
		}
	}
	
	public void printProducts() {
		if (_products[0] == null) {
			System.out.println("Nothing bought");
		} else {
			System.out.printf(_products[0].get_name());
			for (int i = 1; i < _products.length; ++i) {
				if (_products[i] == null) {
					System.out.println(); break;
				} else {
					System.out.printf(", %s", _products[i].get_name());
				}
			}
		}
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
}
