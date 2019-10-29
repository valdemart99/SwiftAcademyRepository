package Task2_FileStructure.exceptions;

public class DirectoryUnavailableException extends Exception {

	public DirectoryUnavailableException(int currentLine) {
		super(currentLine + " - Directory does not exist");
	}
}
