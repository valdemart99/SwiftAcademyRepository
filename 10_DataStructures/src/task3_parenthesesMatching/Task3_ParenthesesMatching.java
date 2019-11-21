package task3_parenthesesMatching;

import java.util.*;

public class Task3_ParenthesesMatching {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input = sc.nextLine().toCharArray();
		ArrayDeque<Character> inputSequence = new ArrayDeque<>();
		boolean shortCheck = true;
		
		for (char c: input) {
			if (c == '(' || c == '[' || c == '{' ) {
				inputSequence.add(c);
			} else {
				switch (c) {
					case ')':
						if (inputSequence.peekLast() == '(') {
							inputSequence.pollLast();
						} else {
							shortCheck = false;
						}
						break;
					case ']':
						if (inputSequence.peekLast() == '[') {
							inputSequence.pollLast();
						} else {
							shortCheck = false;
						}
						break;
					case '}':
						if (inputSequence.peekLast() == '{') {
							inputSequence.pollLast();
						} else {
							shortCheck = false;
						}
						break;
					default:
				}
			}
		}
		
		System.out.println(shortCheck ? "True" : "False");
	}
}
