package Task3_FileManagement;

import java.time.*;

public class File {
	private String name;
	private String location;
	private LocalDateTime creationDate;
	private boolean isDeleted;
	
	public File(String name, String location) {
		this.name = name;
		this.location = location;
		this.creationDate = LocalDateTime.now();
		this.isDeleted = false;
	}
	
	public void move(String newLocation) {
		this.location = newLocation;
	}
	
	public File copy(String newLocation) {
		if (this instanceof ExecutableFile) {
			return new ExecutableFile(this.name, newLocation, ((ExecutableFile)this).getRequiredResources());
		} else if (this instanceof MediaContentFile) {
			return new MediaContentFile(this.name, newLocation, ((MediaContentFile)this).getContent());
		} else if (this instanceof DocumentContentFile) {
			return new DocumentContentFile(this.name, newLocation, ((DocumentContentFile)this).getContent());
		}
		return new File(this.name, newLocation);
	}
	
	public void delete() {
		this.isDeleted = true;
	}
	
	public void execute() {
		if (!this.isDeleted) {
			if (this instanceof ExecutableFile) {
				System.out.printf("Executing %s/%s\n", this.getLocation(), this.getName());
			} else if (this instanceof MediaContentFile) {
				System.out.printf("%s%s%s %s/%s\n%s\n", (char) 9835,(char) 9835,(char) 9835,
						this.getLocation(), this.getName(), ((MediaContentFile)this).getContent());
			} else if (this instanceof DocumentContentFile) {
				System.out.printf("%s%s%s %s/%s\n%s\n", (char) 10003,(char) 10003,(char) 10003,
						this.getLocation(), this.getName(), ((DocumentContentFile)this).getContent());
			}
		}
	}
	
	public void getInfo() {
		String info = "Name: " + this.location + "/" + this.name + (this.isDeleted ? " [DELETED]\n" : "\n") +
				"Creation date: " + this.creationDate + "\nLast " + 
				((this instanceof ExecutableFile) ? "execution date: " : "modification date: ") +
				((this instanceof ExecutableFile) ? ((ExecutableFile)this).getLastExecutedDate() : ((ContentFile)this).getLastModifiedDate());
		if ((this instanceof ExecutableFile)) {
			info += "\nRequired resources:\n";
			for (String resource: ((ExecutableFile)this).getRequiredResources()) {
				info += "       " + resource + "\n";
			}
		}
		System.out.println(info);
	}

	protected String getName() {
		return name;
	}

	protected String getLocation() {
		return location;
	}

	protected LocalDateTime getCreationDate() {
		return creationDate;
	}

	protected boolean isDeleted() {
		return isDeleted;
	}
}
