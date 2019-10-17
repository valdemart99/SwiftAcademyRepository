package Task2_UniversityManagement;

public class Employee extends UniversityPerson {
	private int workHourSalary;
	
	public Employee(String name, String phone) {
		super(name, phone);
		this.workHourSalary = workHourSalary;
	}

	protected int getWorkHourSalary() {
		return workHourSalary;
	}

	protected void setWorkHourSalary(int workHourSalary) {
		this.workHourSalary = workHourSalary;
	}
	
	public void personWorks(University university) {
		university.changeBalance( -this.getWorkHourSalary());
	}
}
