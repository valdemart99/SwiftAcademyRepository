package Task2_UniversityManagement;

public class Teacher extends Employee {
	
	private String[] subjects = new String[20];

	public Teacher(String name, String phone, String... subjects) {
		super(name, phone);
		for (int i = 0; i < subjects.length; ++i) {
			this.subjects[i] = subjects[i];
		}
		super.setWorkHourSalary(25);
	}

	public void adjustTolerance(UniversityPerson workingPerson) {
		if (workingPerson == null) {
			this.changeTolerance(-5);
		} else if (workingPerson instanceof MaintenanceEmployee) {
			this.changeTolerance(2);
		} else if (workingPerson instanceof AdministrationEmployee) {
			this.changeTolerance(3);
		} else if (workingPerson instanceof Teacher) {
			// Teachers do not increase other teachers' tolerance
		} else if (workingPerson instanceof Student) {
			// Students do not influence teachers' tolerance
		}
	}
}
