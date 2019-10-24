package Task1_School;

public class Discipline {
	private String name;
	private short hoursPerWeek;
	
	public Discipline (String name, short hoursPerWeek) {
		this.name = name;
		this.hoursPerWeek = hoursPerWeek;
	}

	public short getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(short hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public String getName() {
		return name;
	}
}
