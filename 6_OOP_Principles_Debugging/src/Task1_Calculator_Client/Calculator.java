package Task1_Calculator_Client;

public class Calculator {

	private double a;
	private double b;
	
	public Calculator() {
		this.a = 1;
		this.b = 1;
	}
	
	public Calculator(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public Calculator(String a, String b) {
		this.a = Double.valueOf(a);
		this.b = Double.valueOf(b);
	}
	
	public void parseInputA(String a) {
		this.a = Double.valueOf(a);
	}
	
	public void parseInputB(String b) {
		this.b = Double.valueOf(b);
	}
	
	public double sum() {
		return this.a + this.b;
	}
	
	public double substract() {
		return this.a - this.b;
	}
	
	public double multiply() {
		return this.a * this.b;
	}
	
	public double divide() {
		return this.a / this.b;
	}
	
	public double percentage() {
		return this.b / this.a;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}
}
