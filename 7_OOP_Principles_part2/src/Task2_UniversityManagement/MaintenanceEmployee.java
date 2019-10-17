package Task2_UniversityManagement;

public class MaintenanceEmployee extends Employee {

	public MaintenanceEmployee(String name, String phone) {
		super(name, phone);
		super.setWorkHourSalary(15);
	}

	public void adjustTolerance(UniversityPerson workingPerson) {
		if (workingPerson == null) {
			this.changeTolerance(-5);
		} else if (workingPerson instanceof MaintenanceEmployee) {
			this.changeTolerance(2);
		} else if (workingPerson instanceof AdministrationEmployee) {
			this.changeTolerance(1);
		} else if (workingPerson instanceof Teacher) {
			this.changeTolerance(-3);
		} else if (workingPerson instanceof Student) {
			this.changeTolerance(-1);
		}
	}
}
