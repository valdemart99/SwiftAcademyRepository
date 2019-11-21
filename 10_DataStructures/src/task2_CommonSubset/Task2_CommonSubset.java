package task2_CommonSubset;

import java.util.*;

public class Task2_CommonSubset {

	static int[] loadList(String input, int count) {
		String[] arrInput = input.split(" ");
		int[] list = new int[count];
		
		for (int i = 0; i < arrInput.length; i++) {
			list[i] = Integer.parseInt(arrInput[i]);
		}
		return list;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] numbers = sc.nextLine().split(" ");
		int[] list1 = loadList(sc.nextLine(), Integer.parseInt(numbers[0]));
		int[] list2 = loadList(sc.nextLine(), Integer.parseInt(numbers[1]));
		
		Set<Integer> uniques = new HashSet<>();
		Set<Integer> commonNumbers = new HashSet<>();
		
		for (int i = 0; i < list1.length; i++) {
			uniques.add(list1[i]);
		}
		
		for (int j = 0; j < list2.length; j++) {
			if(uniques.contains(list2[j])) {
				commonNumbers.add(list2[j]);
			}
		}
		
		if (commonNumbers.isEmpty()) {
			System.out.println("NO");
		} else {
			for (int x: commonNumbers) {
				System.out.print(x + " ");
			}
		}
	}
}
