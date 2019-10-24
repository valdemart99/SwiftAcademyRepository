package Task2_FileStructure;

public abstract class FileSystemObject {
	private String parent;
	private String name;
	
	public FileSystemObject(String parent, String name) {
		this.parent = parent;
		this.name = name;
	}

	public boolean equals(String fullPathName) {
		return (this.parent + this.name).equals(fullPathName) ? true : false;
	}
	
	public String getParent() {
		return parent;
	}

	public String getName() {
		return name;
	}
}
