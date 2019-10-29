package Task2_FileStructure;

import java.util.*;

import Task2_FileStructure.exceptions.*;

public class FileSystem {
	private List<FileSystemObject> mft;
	private int lineCounter;
	private static final char[] allowedSymbols = {
			'-', '"', '(', ')', '_', '!', '.', '&',
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			'3', '4', '5', '6', '7', '8', '9' };
	private static final char[] allowedNonSpecialSymbols = {
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			'3', '4', '5', '6', '7', '8', '9' };
	
	public FileSystem() {
		this.mft = new ArrayList<>();
		this.lineCounter = 1;
	}
	
	public void createNewSystemObject(UserInput input) {
		
		switch (input.getCommandType()) {
			case "mkdir":
				this.mft.add(new FolderObject(input.getPathName(), input.getObjectName()));
				break;
			case "touch":
				this.mft.add(new FileObject(input.getPathName(), input.getObjectName()));
				break;
			}
	}
	
	public boolean checkObjectInput(UserInput input) throws Exception {

		if (!allowedSymbolsCheck(input.getObjectName())) {
			throw new InvalidFileNameException(this.lineCounter);
		}
		
		switch(input.getCommandType()) {
			case "touch":
				if (!checkInputExtension(input.getObjectName())) {
					throw new InvalidFileNameException(this.lineCounter);
				}
			case "mkdir":
				if (!isPathAllowed(input.getParentFolder())) {
					throw new IllegalOperationException(this.lineCounter);
				}
				if (!isFolderAvailable(input.getPathName())) {
					throw new DirectoryUnavailableException(this.lineCounter);
				}
		}
		return true;
	}
	
	private boolean allowedSymbolsCheck(String name) {
		char[] nameChars = name.toCharArray();
		boolean check = false;
		
		if (nameChars.length == 0) {
			return false;
		}
		
		for (int i = 0; i < allowedNonSpecialSymbols.length; ++i) {
			if (nameChars[0] == allowedNonSpecialSymbols[i]) {
				check = true; break;
			}
		}
		
		if (!check) {
			return false;
		}
		check = false;
		
		for (int i = 1; i < nameChars.length; ++i) {
			for (int j = 0; j < allowedSymbols.length; ++j) {
				if (nameChars[i] == allowedSymbols[j]) {
					check = true; break;
				}
			}
			if (!check) {
				return false;
			}
			check = false;
		}
		
		return true;
	}

	private boolean checkInputExtension(String name) {
		int dotIndex = -1;
		char[] nameChars = name.toCharArray();
		
		for (int i = nameChars.length -1 ; i >= 0; --i) {
			if (nameChars[i] == '.') {
				dotIndex = i;
			}
		}
		
		if (dotIndex > 0 && dotIndex >= nameChars.length - 7) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isFolderAvailable(String path) {
		
		if (path.equals("")) {
			return true;
		}
		
		for (FileSystemObject fso: mft) {
			if (fso.equals(path)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isPathAllowed(String parent) {
		
		for (FileSystemObject fso: mft) {
			if (fso.getName().equals(parent) && fso instanceof FileObject) {
				return false;
			}
		}
		return true;
	}
	
	public List<FileSystemObject> getMft() {
		return mft;
	}

	public void setMft(List<FileSystemObject> mft) {
		this.mft = mft;
	}

	public int getLineCounter() {
		return lineCounter;
	}

	public void setLineCounter(int lineCounter) {
		this.lineCounter = lineCounter;
	} 
	
	public void incrementCounter() {
		this.lineCounter++;
	}
}
