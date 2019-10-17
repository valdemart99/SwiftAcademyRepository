package Task1_PeoplePresentation;

public class Worker extends Person {
	private double weekSalary;
	private double workHoursPerDay;
	
	public Worker(String name, String lastName, double weekSalary, double workHoursPerDay) {
		super(name, lastName);
		this.weekSalary = weekSalary;
		this.workHoursPerDay = workHoursPerDay;
	}
	
	public static boolean checkWorkerInput(String name, String lastName, String weekSalary, String workHoursPerDay) {
		return inputNameCheck(name) && inputNameCheck(lastName) &&
				checkInputPositiveNumber(weekSalary) && checkInputPositiveNumber(workHoursPerDay);
	}
	
	public void getInfo() {
		super.printNames();
		System.out.println("Worker");
		System.out.println("Week salary: "+ this.weekSalary);
		System.out.printf("Hours per day: %.2f\n", this.workHoursPerDay);
		System.out.printf("Salary per hour: %.2f\n", this.getHourSalary());
		System.out.println();
	}
	
	public double getHourSalary() {
		return (this.weekSalary /5) / this.workHoursPerDay;
	}

	public double getWeekSalary() {
		return weekSalary;
	}

	public void setWeekSalary(double weekSalary) {
		this.weekSalary = weekSalary;
	}

	public double getWorkHoursPerDay() {
		return workHoursPerDay;
	}

	public void setWorkHoursPerDay(double workHoursPerDay) {
		this.workHoursPerDay = workHoursPerDay;
	}
}
