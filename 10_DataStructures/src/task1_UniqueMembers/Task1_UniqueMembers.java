package task1_UniqueMembers;

import java.util.*;

public class Task1_UniqueMembers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberCount = sc.nextInt();
		sc.nextLine();
		String[] input = sc.nextLine().split(" ");
		Set<Integer> uniques = new HashSet<>();
		
		for (int i = 0; i < numberCount; ++i) {
			uniques.add(Integer.parseInt(input[i]));
		}
		
		for (int u: uniques) {
			System.out.print(u + " ");
		}
	}
}
