package Task3_FileManagement;

import java.time.*;

public class ContentFile extends File {
	private String content;
	private LocalDateTime lastModifiedDate;
	
	public ContentFile(String name, String location, String content) {
		super(name, location);
		this.content = content;
		this.lastModifiedDate = super.getCreationDate();
	}

	public void modify(String data) {
		this.content = data;
	}

	protected String getContent() {
		return content;
	}

	protected void setContent(String content) {
		this.content = content;
	}

	protected LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

}
