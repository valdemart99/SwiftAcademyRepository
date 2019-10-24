package Task2_FileStructure;

import java.util.*;

public class FileSystem {
	private List<FileSystemObject> mft;
	
	public FileSystem() {
		this.mft = new ArrayList<>();
	}
	
	public FileSystemObject createNew(String command) {
		String[] input = command.split(" ");
		String[] fullObjName = input[1].split("/");
		String objName = fullObjName[fullObjName.length - 1];
		
	}
	
	public void checkName(String name) throws Exception {
		
	}
	
	public void checkFileName(String name) throws Exception {
		
	}

	public List<FileSystemObject> getMft() {
		return mft;
	}

	public void setMft(List<FileSystemObject> mft) {
		this.mft = mft;
	} 
}
