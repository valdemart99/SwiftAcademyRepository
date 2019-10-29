package Task2_FileStructure.exceptions;

public class IllegalOperationException extends Exception{

	public IllegalOperationException(int currentLine) {
		super(currentLine + " - Illegal operation");
	}
}
