package Task2_FileStructure;

import java.util.*;

public class Task2_FileStructure {

	public static void main(String[] args) {
		FileSystem mft = new FileSystem();
		Scanner scan = new Scanner(System.in);
		String command = scan.nextLine();
		
		while (!command.equals("END")) {
			UserInput input = new UserInput(command);
			try {
				if (mft.checkObjectInput(input)) {
					mft.createNewSystemObject(input);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			command = scan.nextLine();
			mft.incrementCounter();
		}
		
		scan.close();
	}
}
