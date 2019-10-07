import java.util.*;

public class Task0_Classes {
	// Used to run both a and b classes
	public static void main(String[] args) {
		Person anotherPerson = new Person();
		Scanner input = new Scanner(System.in);
		String inputName = input.nextLine();
		
		while(inputName.length() == 0) {
			inputName = input.nextLine();
		}		
		anotherPerson.setName(inputName);
		
		short inputAge = input.nextShort();
		
		while(inputAge < 0) {
			inputAge = input.nextShort();
		}		
		anotherPerson.setAge(inputAge);
		
		anotherPerson.printGreeting();
		
		// Next task
		String brand = input.nextLine();
		String model = input.nextLine();
		input.nextLine();
		short productionYear = input.nextShort();
		short horsePower = input.nextShort();
		Car anotherCar = new Car(brand,model,horsePower,productionYear);
		
		System.out.println(anotherCar.taxCalculation());
		
		input.close();
	}
	
}
class Person {
	
	private String name;
	private short age;

	public Person() {
		this.name = "No name";
		this.age = -1;
	}

	public Person(String name) {
		this.name = name;
		this.age = -1;
	}

	public Person(String name, short age) {
		this.name = name;
		this.age = age;
	}

	public void printGreeting() {
		if (age != -1) {
			System.out.printf("Hello, I am %s. I am %d years old.\n", name, (int) age);
		} else  {
			if(name.equals("No name")) {
				System.out.println("I am John Doe.");
			} else {
				System.out.printf("Hello, I am %s.\n", name);
			}
		} 
	}

	public String getName() {
		return name;
	}

	public short getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(short age) {
		this.age = age;
	}

}

class Car {
	private String brand;
	private String model;
	private short horsePower;
	private short productionYear;
	
	public Car(String brand, String model, short horsePower, short productionYear) {
		this.brand = brand;
		this.model = model;
		this.horsePower = horsePower;
		this.productionYear = productionYear;
	}
	
	private int checkCategory() {
		int carAge = 2019 - this.productionYear;
		if (carAge <= 8) {
			return 1;
		} else if (carAge <= 15) {
			return 2;
		} else if (carAge <= 25) {
			return 3;
		} else {
			return 4;
		}
	}
	
	public double taxCalculation() {
		int category = this.checkCategory();
		int initialTax = 0;
		switch (category) {
			case 1: initialTax = 150; break;
			case 2: initialTax = 200; break;
			case 3: initialTax = 300; break;
			case 4: initialTax = 500; break;
		}
		
		if (this.horsePower < 80) {
			return initialTax * 1.2;
		} else if (this.horsePower > 140) {
			return initialTax * 1.45;
		} else {
			return initialTax;
		}
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public short getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(short horsePower) {
		this.horsePower = horsePower;
	}

	public short getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(short productionYear) {
		this.productionYear = productionYear;
	}
}