package Task3_FileManagement;

public class FileSystem {
	private File[] mft;
	
	public FileSystem() {
		this.mft = new File[500];
	}

	protected File[] getMft() {
		return mft;
	}

	protected void setMft(File[] mft) {
		this.mft = mft;
	}
	
	public File findByName(String name) {
		for (File x: mft) {
			if (x != null && x.getName().equals(name)) {
				return x;
			}
		}
		return null;
	}
	
	public void createNewFile(File newFile) {
		for (int i = 0; i < mft.length; ++i) {
			if(mft[i] == null) {
				mft[i] = newFile; break;
			}
		}
	}
	
	public boolean checkRequiredResources(String[] resources) {
		int hitCounter = 0;
		for (String resource: resources) {
			for (int i = 0; i < this.mft.length; ++i) {
				if (this.mft[i] == null) {
					break;
				}
				if (this.mft[i].getName().equals(resource)) {
					hitCounter++;
					if (hitCounter == resources.length) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
