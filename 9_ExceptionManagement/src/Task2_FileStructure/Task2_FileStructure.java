package Task2_FileStructure;

import java.util.*;

public class Task2_FileStructure {

	public static void main(String[] args) {
		FileSystem mft = new FileSystem();
		Scanner scan = new Scanner(System.in);
		String command = scan.nextLine();
		
		while (!command.equals("END")) {
			mft.createNew(command);
			command = scan.nextLine();
		}
		
		scan.close();
	}
}
