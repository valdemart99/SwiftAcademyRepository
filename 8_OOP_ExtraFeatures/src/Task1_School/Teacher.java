package Task1_School;

public class Teacher extends Person {
	private Discipline[] disciplines;
	
	public Teacher(String name, Discipline[] disciplines) {
		super(name);
		this.disciplines = disciplines;
	}

	public Discipline[] getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(Discipline[] disciplines) {
		this.disciplines = disciplines;
	}
}
