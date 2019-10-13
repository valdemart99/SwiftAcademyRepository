package Task4_Market;

import java.util.*;

public class Task4_Market {
	
	private static String errBalance = "Balance can’t be negative.";
	private static String errPrice = "Price can’t be negative.";
	private static String errName = "Name can’t be empty.";
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Person[] personList = new Person[200];
		String[] personArray = input.nextLine().split(";");
		int counter = 0;
		boolean properInput = true;
		
		for (int i = 0; i < personArray.length; ++i) {
			String[] tempArr = personArray[i].split("=");
			
			if (tempArr[0].length() == 0) {
				System.out.println(errName);
				properInput = false; break;
			} else if (Double.valueOf(tempArr[1]) < 0) {
				System.out.println(errBalance);
				properInput = false; break;
			} else {
				personList[counter++] = new Person(tempArr[0], Double.valueOf(tempArr[1]));
			}
		}
		
		String[] productArray = input.nextLine().split(";");
		Product[] productList = new Product[500];
		counter = 0;
		
		if (properInput) {
			
			for (int i = 0; i < productArray.length; ++i) {
				String[] tempArr = productArray[i].split("=");
				
				if (tempArr[0].length() == 0) {
					System.out.println(errName);
					properInput = false; break;
				} else if (Double.valueOf(tempArr[1]) < 0) {
					System.out.println(errPrice);
					properInput = false; break;
				} else {
					productList[counter++] = new Product(tempArr[0], Double.valueOf(tempArr[1]));
				}
			}
		}
		
		
		if (properInput) {
			String command = input.nextLine();
			
			while(!command.contentEquals("END")) {
				int indPerson = 0;
				int indProduct = 0;
				
				for (int i = 0; i < personList.length; ++i) {
					if(command.contains(personList[i].get_name())) {
						indPerson = i; break;
					}
				}
				
				for (int j = 0; j < productArray.length; ++j) {
					if(command.contains(productList[j].get_name())) {
						indProduct = j; break;
					}
				}
				
				if (personList[indPerson].get_balance() >= productList[indProduct].get_price()) {
					personList[indPerson].addProducts(productList[indProduct].get_name());
					personList[indPerson].set_balance(personList[indPerson].get_balance() - productList[indProduct].get_price());
					System.out.printf("%s bought %s\n", personList[indPerson].get_name(), productList[indProduct].get_name());
				} else {
					System.out.printf("%s can't afford %s\n", personList[indPerson].get_name(), productList[indProduct].get_name());
				}
				
				command = input.nextLine();
			}
			
			for (int i = 0 ; i < personList.length; ++i) {
				if(personList[i] != null) {
					System.out.printf("%s - ", personList[i].get_name());
					personList[i].printProducts();
				}
			}
		}
		
		input.close();
	}

}
