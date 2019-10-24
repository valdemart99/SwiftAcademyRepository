package Task1_School;

public class Student extends Person{
	private short idNumber;
	
	public Student(String name, short idNumber) {
		super(name);
		this.idNumber = idNumber;
	}
	
	public Student(String name) {
		super(name);
	}

	public short getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(short idNumber) {
		this.idNumber = idNumber;
	}
}
