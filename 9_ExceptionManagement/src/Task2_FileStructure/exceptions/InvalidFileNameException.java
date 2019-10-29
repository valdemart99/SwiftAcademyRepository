package Task2_FileStructure.exceptions;

public class InvalidFileNameException extends Exception{
	
	public InvalidFileNameException(int currentLine) {
		super(currentLine + " - Invalid name specified");
	}
}
