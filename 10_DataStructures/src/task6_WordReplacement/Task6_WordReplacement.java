package task6_WordReplacement;

import java.util.*;

public class Task6_WordReplacement {
	
	// the two following staticx methods are done this way to make the code easier to read
	// and avoid creating extra objects
	public static ArrayList<String> getWordList(char[] originalText) {
		ArrayList<String> wordList = new ArrayList<>();
		StringBuilder word = new StringBuilder();
		
		for (int i = 0; i < originalText.length; i++) {
			if ((originalText[i] >= 65 && originalText[i] <= 90) || 
				(originalText[i] >= 97 && originalText[i] <= 122)) {
				word.append(originalText[i]);
			} else {
				wordList.add(word.toString());
				wordList.add(String.valueOf(originalText[i]));
				word.delete(0, word.length());
			}
		}
		return wordList;
	}
	
	public static ArrayList<String> editInput(ArrayList<String> wordList, ArrayList<String[]> correctors) {
		for (int i = 0; i < wordList.size(); ++i) {
			for (int j = 0; j < correctors.size(); ++j) {
				if(wordList.get(i).equalsIgnoreCase(correctors.get(j)[0])) {
					wordList.set(i, correctors.get(j)[1]);
					break;
				}
			}
		}
		return wordList;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> wordList = getWordList(sc.nextLine().toCharArray());
		
		int correctionCount = sc.nextInt();
		sc.nextLine();
		ArrayList<String[]> correctors = new ArrayList<>();
		
		for (int i = 0; i < correctionCount; ++i) {
			correctors.add(sc.nextLine().split(" "));
		}
		
		wordList = editInput(wordList, correctors);
		
		for (String s: wordList) {
			System.out.print(s);
		}
	}
}
