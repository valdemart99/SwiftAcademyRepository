package Task3_FileManagement;

public class DocumentContentFile extends ContentFile {

	public DocumentContentFile(String name, String location, String content) {
		super(name, location, content);
	}
	
	public void execute() {
		if (!this.isDeleted()) {
			System.out.printf("%s%s%s %s/%s\n%s\n", (char) 10003,(char) 10003,(char) 10003,
					this.getLocation(), this.getName(), this.getContent());
		}
	}
}
