package Task2_FileStructure;

public class FolderObject extends FileSystemObject{
	private FileSystemObject children;
	
	public FolderObject(String parent, String name) {
		super(parent, name);
	}

	public FileSystemObject getChildren() {
		return children;
	}

	public void setChildren(FileSystemObject children) {
		this.children = children;
	}
}
