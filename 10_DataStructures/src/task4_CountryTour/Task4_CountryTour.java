package task4_CountryTour;

import java.util.*;

public class Task4_CountryTour {
	
	private static int checkTour(ArrayList<City> cities, int startingCity) {
		int food = 0;
		int currentCity = startingCity;
		
		do {
			food += cities.get(currentCity).getFood() - cities.get(currentCity).getDistance();
			if (food < 0) {
				return -1;
			}
			currentCity = (currentCity == cities.size() - 1) ? 0 : ++currentCity;
		} while (currentCity != startingCity);
		
		return startingCity;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<City> cities = new ArrayList<>();
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < n; ++i) {
			String[] input = sc.nextLine().split(" ");
			cities.add(new City(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}
		
		int result = -1;
		
		for (int i = 0; i < n; ++i) {
			if ( (result = checkTour(cities, i)) >= 0) {
				break;
			}
		}
		
		System.out.println(result >= 0 ? result + 1 : "NO");
	}
}
