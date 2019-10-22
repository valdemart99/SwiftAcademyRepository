package Task3_FileManagement;

public class MediaContentFile extends ContentFile {

	public MediaContentFile(String name, String location, String content) {
		super(name, location, content);
	}

	public void execute() {
		if (!this.isDeleted()) {
			System.out.printf("%s%s%s %s/%s\n%s\n", (char) 9835,(char) 9835,(char) 9835,
					this.getLocation(), this.getName(), this.getContent());
		}
	}
}
