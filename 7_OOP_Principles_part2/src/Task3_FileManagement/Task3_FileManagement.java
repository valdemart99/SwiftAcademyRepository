package Task3_FileManagement;

import java.util.*;

public class Task3_FileManagement {
	
	private static int getCommand(String command) {
		String[] commandList = { "MAKE", "MOVE", "MOD", "COPY", "DEL", "EXEC", "INFO"};
		for (int i = 0; i < commandList.length; ++i) {
			if (commandList[i].equals(command)) { return i; }
		}
		return -1;
	}
	
	private static void processCommand(FileSystem fileSystem, String command) {
		String[] tempArr = command.split(" ");
		
		switch(getCommand(tempArr[0])) {
			case 0:
				if (tempArr[3].contains("CONTENT")) {
					if (tempArr[1].endsWith(".avi") || tempArr[1].endsWith(".mp3")) {
						fileSystem.createNewFile(new MediaContentFile(tempArr[1], tempArr[2], tempArr[3].substring(8)));
					} else {
						fileSystem.createNewFile(new DocumentContentFile(tempArr[1], tempArr[2], tempArr[3].substring(8)));
					}
				} else {
					String[] resources = Arrays.copyOfRange(tempArr, 3, tempArr.length);
					if (fileSystem.checkRequiredResources(resources)) {
						fileSystem.createNewFile(new ExecutableFile(tempArr[1], tempArr[2], resources));
					}
				}
				break;
			case 1:
				fileSystem.findByName(tempArr[1]).move(tempArr[2]);
				break;
			case 2:
				if (fileSystem.findByName(tempArr[1]) instanceof ContentFile) {
					((ContentFile) fileSystem.findByName(tempArr[1])).modify(tempArr[2]);
				}
				break;
			case 3:
				fileSystem.createNewFile(fileSystem.findByName(tempArr[1]).copy(tempArr[2]));
				break;
			case 4:
				fileSystem.findByName(tempArr[1]).delete();
				break;
			case 5:
				if (fileSystem.findByName(tempArr[1]) instanceof ExecutableFile) {
					recursiveExecution(fileSystem, (ExecutableFile)fileSystem.findByName(tempArr[1]));
				} else {
					fileSystem.findByName(tempArr[1]).execute();
				}
				break;
			case 6:
				fileSystem.findByName(tempArr[1]).getInfo();
				break;
		}
	}
	
	public static void recursiveExecution(FileSystem fileSystem, ExecutableFile currentFile) {
		currentFile.execute();
		for (String resource: currentFile.getRequiredResources()) {
			if (fileSystem.findByName(resource) instanceof ExecutableFile) {
				recursiveExecution(fileSystem, (ExecutableFile)fileSystem.findByName(resource));
			} else {
				fileSystem.findByName(resource).execute();
			}
		}
	}
	
	public static void main(String[] args) {
		FileSystem fileSystem = new FileSystem();
		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();
		
		while (!command.equals("END")) {
			processCommand(fileSystem, command);
			System.out.println();
			command = sc.nextLine();
		}
	}
}
