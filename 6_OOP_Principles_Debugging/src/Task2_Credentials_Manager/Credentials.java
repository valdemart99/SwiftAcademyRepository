package Task2_Credentials_Manager;

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
		if (this.password.equals(oldPassword) && checkOldPasswords(newPassword)) {
			this.password = newPassword;
			this.updatePassHistory(newPassword);
			System.out.println("CHPASS success");
		} else {
			System.out.println("CHPASS fail");
		}
	}
	
	private boolean checkOldPasswords(String newPassword) {
		boolean check = true;
		for (int i = 0; i < passHistory.length; ++i) {
			if (passHistory[i] == null) {
				break;
			} else if (passHistory[i].equals(newPassword)) {
				check = false; break;
			}
		}
		return check;
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
