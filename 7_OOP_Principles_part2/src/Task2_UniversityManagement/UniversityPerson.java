package Task2_UniversityManagement;

public class UniversityPerson {
	private String name;
	private String phone;
	private int tolerance;
	
	public UniversityPerson(String name, String phone) {
		this.name = name;
		this.phone = phone;
		this.tolerance = 20;
	}

	public int getTolerance() {
		return tolerance;
	}

	public void setTolerance(int tolerance) {
		this.tolerance = tolerance;
	}
	
	public void changeTolerance(int tolerance) {
		this.tolerance += tolerance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
