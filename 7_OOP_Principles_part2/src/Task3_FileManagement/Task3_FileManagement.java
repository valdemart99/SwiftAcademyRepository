package Task3_FileManagement;

import java.util.*;

public class Task3_FileManagement {
	
	private static void processCommand(FileSystem fileSystem, String command) {
		String[] tempArr = command.split(" ");
		
		switch(tempArr[0]) {
			case "MAKE":
				executeMakeCommand(fileSystem, tempArr);
				break;
			case "MOVE":
				fileSystem.findByName(tempArr[1]).move(tempArr[2]);
				break;
			case "MOD":
				if (fileSystem.findByName(tempArr[1]) instanceof ContentFile) {
					((ContentFile) fileSystem.findByName(tempArr[1])).modify(tempArr[2]);
				}
				break;
			case "COPY":
				fileSystem.createNewFile(fileSystem.findByName(tempArr[1]).copy(tempArr[2]));
				break;
			case "DEL":
				fileSystem.findByName(tempArr[1]).delete();
				break;
			case "EXEC":
				if (fileSystem.findByName(tempArr[1]) instanceof ExecutableFile) {
					recursiveExecution(fileSystem, (ExecutableFile)fileSystem.findByName(tempArr[1]));
				} else {
					fileSystem.findByName(tempArr[1]).execute();
				}
				break;
			case "INFO":
				fileSystem.findByName(tempArr[1]).getInfo();
				break;
		}
	}
	
	public static void executeMakeCommand(FileSystem fileSystem, String[] commands) {
		if (commands[3].contains("CONTENT")) {
			if (commands[1].endsWith(".avi") || commands[1].endsWith(".mp3")) {
				fileSystem.createNewFile(new MediaContentFile(commands[1], commands[2], commands[3].substring(8)));
			} else {
				fileSystem.createNewFile(new DocumentContentFile(commands[1], commands[2], commands[3].substring(8)));
			}
		} else {
			String[] resources = Arrays.copyOfRange(commands, 3, commands.length);
			if (fileSystem.checkRequiredResources(resources)) {
				fileSystem.createNewFile(new ExecutableFile(commands[1], commands[2], resources));
			}
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
