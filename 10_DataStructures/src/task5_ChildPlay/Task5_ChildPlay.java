package task5_ChildPlay;

import java.util.*;

public class Task5_ChildPlay {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] inputArray = sc.nextLine().split(" ");
		LinkedList<Integer> children = new LinkedList<>();
		
		for (int i = 0; i < n; ++i) {
			children.add(Integer.parseInt(inputArray[i]));
		}
		
		int rounds = 0;
		
		while(true) {
			ArrayList<Integer> forRemoval = new ArrayList<>();
			int index = 0;
			while (index < children.size() - 1) {
				if (children.get(index) < children.get(index + 1)) {
					forRemoval.add(index + 1);
				}
				index += 2;
			}
			if(forRemoval.isEmpty()) {
				break;
			} else {
				for (int i = forRemoval.size() - 1; i >= 0; i-- ) {
					children.remove(children.get(forRemoval.get(i)));
				}
				rounds++;
			}
		}
		
		System.out.println(rounds);
	}
}
