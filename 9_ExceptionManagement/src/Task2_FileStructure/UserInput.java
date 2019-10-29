package Task2_FileStructure;

public class UserInput {
	private String commandType;
	private String objectName;
	private String pathName;
	private String parentFolder;
	
	public UserInput(String command) {
		String[] input = command.split(" ");
		String[] fullNameArray = input[1].split("/");
		
		this.commandType = input[0];
		this.objectName = fullNameArray[fullNameArray.length -1];
		this.pathName = input[1].substring(0, input[1].length() - this.objectName.length());
		if (fullNameArray.length > 1) {
			this.parentFolder = fullNameArray[fullNameArray.length -2];
		} else {
			this.parentFolder = "";
		}
	}

	public String getCommandType() {
		return commandType;
	}

	public String getObjectName() {
		return objectName;
	}

	public String getPathName() {
		return pathName;
	}

	public String getParentFolder() {
		return parentFolder;
	}
}
