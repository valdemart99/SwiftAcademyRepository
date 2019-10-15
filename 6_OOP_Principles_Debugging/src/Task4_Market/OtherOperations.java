package Task4_Market;

public class OtherOperations {
	static int personIndex(String command, Person[] personList) {
		for (int i = 0; i < personList.length; ++i) {
			if (command.contains(personList[i].get_name())) {
				return i;
			}
		}
		return -1;
	}
	
	static int productIndex(String command, Product[] productList) {
		for (int i = 0; i < productList.length; ++i) {
			if (command.contains(productList[i].get_name())) {
				return i;
			}
		}
		return -1;
	}
	
	static void addProducts(Person thisPerson, String product) {
		for (int i = 0; i < thisPerson.get_products().length; ++i) {
			if (thisPerson.get_products()[i] == null) {
				thisPerson.get_products()[i] = new Product(product); break;
			}
		}
	}
	
	static void printProducts(Person person) {
		if (person.get_products()[0] == null) {
			System.out.println("Nothing bought");
		} else {
			System.out.printf(person.get_products()[0].get_name());
			
			for (int i = 1; i < person.get_products().length; ++i) {
				if (person.get_products()[i] == null) {
					System.out.println(); break;
				} else {
					System.out.printf(", %s", person.get_products()[i].get_name());
				}
			}
		}
	}
}
