package Task3_Credentials_Manager;

public class Credentials {
	private String username;
	private String password;
	private String[] passHistory = new String[100];
	
	public Credentials(String username, String password) {
		this.username = username;
		this.password = password;
		this.passHistory[0] = password;
		System.out.println("ENROLL success");
	}

	public void setPassword(String oldPassword, String newPassword) {
		if (this.password.equals(oldPassword)) {
			try {
				checkOldPasswords(newPassword);
				this.password = newPassword;
				this.updatePassHistory(newPassword);
				System.out.println("CHPASS success");
			} catch (OldPasswordConflictException e) {
				System.out.println("CHPASS failed " + e.getMessage());
			}
		} else {
			System.out.println("CHPASS failed");
		}
	}
	
	private void checkOldPasswords(String newPassword) throws OldPasswordConflictException {
		int conflictIndex = OldPasswordConflictException.getPasswordConflictIndex(this.passHistory, newPassword);
		if (conflictIndex >= 0) {
			throw new OldPasswordConflictException(conflictIndex);
		}
	}
	
	private void updatePassHistory(String newPassword) {
		for (int i = 0; i < passHistory.length; ++i) {
			if (passHistory[i] == null) {
				passHistory[i] = newPassword; break;
			}
		}
	}
	
	public void checkCurrentPassword(String password) {
		if (this.password.equals(password)) {
			System.out.println("AUTH success");
		} else {
			System.out.println("AUTH fail");
		}
	}
	
	public String getUsername() {
		return username;
	}
}
