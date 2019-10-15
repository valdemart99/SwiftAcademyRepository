package Task4_Market;

import java.util.*;

public class Task4_Market {

	private static boolean properInput = true;
	
	private static Person[] getPersonList(String command) {
		String[] persons = command.split(";");
		Person[] personList = new Person[200];
		int personCount = 0;
		
		for (String singlePerson: persons) {
			String[] tempArr = singlePerson.split("=");
			
			if (tempArr[0].length() == 0) {
				System.out.println("Name can’t be empty.");
				properInput = false; break;
			} else if (Double.valueOf(tempArr[1]) < 0) {
				System.out.println("Balance can’t be negative.");
				properInput = false; break;
			} else {
				personList[personCount++] = new Person(tempArr[0], Double.valueOf(tempArr[1]));
			}
		}
		
		return personList;
	}
	
	private static Product[] getProductList(String command) {
		String[] products = command.split(";");
		Product[] productList = new Product[500];
		int productCount = 0;
		
		for (String singleProduct: products) {
			String[] tempArr = singleProduct.split("=");
			
			if (tempArr[0].length() == 0) {
				System.out.println("Name can’t be empty.");
				properInput = false; break;
			} else if (Double.valueOf(tempArr[1]) < 0) {
				System.out.println("Price can’t be negative.");
				properInput = false; break;
			} else {
				productList[productCount++] = new Product(tempArr[0], Double.valueOf(tempArr[1]));
			}
		}
		
		return productList;
	}
	
	private static void buyProduct(String command, Person[] personList, Product[] productList) {
		Person thisPerson = personList[OtherOperations.personIndex(command, personList)];
		Product thisProduct = productList[OtherOperations.productIndex(command, productList)];
		
		if (thisPerson.get_balance() >= thisProduct.get_price()) {
			OtherOperations.addProducts(thisPerson, thisProduct.get_name());
			thisPerson.set_balance(thisPerson.get_balance() - thisProduct.get_price());
			System.out.printf("%s bought %s\n", thisPerson.get_name(), thisProduct.get_name());
		} else {
			System.out.printf("%s can't afford %s\n", thisPerson.get_name(), thisProduct.get_name());
		}
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int counter = 0;
		
		Person[] personList = new Person[200];
		Product[] productList = new Product[500];

		String command = input.nextLine();
		
		while(!command.equals("END") && properInput) {
			
			if (counter == 0) {
				personList = getPersonList(command);
			} else if (counter == 1) {
				productList = getProductList(command);
			} else {
				buyProduct(command, personList, productList);
			}
			
			if (properInput) { command = input.nextLine(); }
			counter++;
		}
		
		input.close();
		
		if (properInput) {
			for (int i = 0 ; i < personList.length; ++i) {
				if(personList[i] != null) {
					System.out.printf("%s - ", personList[i].get_name());
					OtherOperations.printProducts(personList[i]);
				}
			}
		}
		
	}

}
