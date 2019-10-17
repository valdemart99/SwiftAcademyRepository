package Task2_UniversityManagement;

public class Student extends UniversityPerson {
	private String facultyNumber;
	private String[] subjects = new String[20];

	public Student(String name, String phone, String facultyNumber, String... subjects) {
		super(name, phone);
		this.facultyNumber = facultyNumber;
		for (int i = 0; i < subjects.length; ++i) {
			this.subjects[i] = subjects[i];
		}
	}
	
	public void personWorks(University university) {
		if (this.getTolerance() >= 50) {
			university.changeBalance(10);
		}
		this.changeTolerance(2);
	}
	
	public void adjustTolerance(UniversityPerson workingPerson) {
		if (workingPerson == null) {
			this.changeTolerance(-5);
		} else if (workingPerson instanceof MaintenanceEmployee) {
			this.changeTolerance(2);
		} else if (workingPerson instanceof AdministrationEmployee) {
			this.changeTolerance(3);
		} else if (workingPerson instanceof Teacher) {
			this.changeTolerance(3);
		} else if (workingPerson instanceof Student) {
			// Students influence only their own tolerance, not the other students
		}
	}
}
