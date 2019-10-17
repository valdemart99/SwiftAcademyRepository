package Task3_FileManagement;

import java.time.*;

public class ExecutableFile extends File{
	private LocalDateTime lastExecutedDate;
	private String[] requiredResources;
	
	public ExecutableFile(String name, String location, String... resources) {
		super(name, location);
		this.lastExecutedDate = super.getCreationDate();
		this.requiredResources = resources;
	}

	protected LocalDateTime getLastExecutedDate() {
		return lastExecutedDate;
	}

	protected String[] getRequiredResources() {
		return requiredResources;
	}

}
