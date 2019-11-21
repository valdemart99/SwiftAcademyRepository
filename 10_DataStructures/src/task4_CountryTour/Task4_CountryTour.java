package task4_CountryTour;

import java.util.*;

public class Task4_CountryTour {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<City> cities = new LinkedList<>();
		int n = sc.nextInt();
		sc.hasNextLine();
		
		for (int i = 0; i < n; ++i) {
			String[] input = sc.nextLine().split(" ");
			cities.add(new City(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}
		
		
	}
}
