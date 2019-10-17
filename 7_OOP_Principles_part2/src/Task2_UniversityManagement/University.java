package Task2_UniversityManagement;

public class University {
	private int balance;
	private UniversityPerson[] personList;
	
	public University() {
		this.balance = 500;
		this.personList = new UniversityPerson[500];
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	protected UniversityPerson[] getPersonList() {
		return personList;
	}

	protected void setPersonList(UniversityPerson[] personList) {
		this.personList = personList;
	}
	
	protected void addPersonEntry(UniversityPerson person) {
		for (int i = 0; i < this.personList.length; ++i) {
			if (this.personList[i] == null) {
				this.personList[i] = person; break;
			}
		}
	}

	public void changeBalance(int balance) {
		this.balance += balance;
	}
	
	public int getPersonIndex(String personName) {
		for (int i = 0; i < this.personList.length; ++i) {
			if (this.personList[i].getName().equals(personName)) {
				return i;
			}
		}
		return -1;
	}
	
	public int checkTolerance() {
		for (int i = 0; i < this.personList.length; ++i) {
			if (this.personList[i] != null) {
				if (this.personList[i].getTolerance() <= 0) {
					return i;
				}
			} else {
				break;
			}
		}
		return -1;
	}
}
