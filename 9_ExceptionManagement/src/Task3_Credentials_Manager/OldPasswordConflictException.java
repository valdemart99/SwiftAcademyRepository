package Task3_Credentials_Manager;

public class OldPasswordConflictException extends Exception{

	public OldPasswordConflictException(int index) {
		super("[Password matches a recently used one: " + index + "]");
	}
	
	public static int getPasswordConflictIndex(String[] passHistory, String newPass) {
		int conflictIndex = -1;
		for (int i = 0; i < passHistory.length; ++i) {
			if (passHistory[i] == null) {
				if (conflictIndex > -1) {
					conflictIndex = i - 1 - conflictIndex;
				}
				break;
			} else if (passHistory[i].equals(newPass)) {
				conflictIndex = i;
			}
		}
		return conflictIndex;
	}
}
