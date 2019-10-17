package Task1_PeoplePresentation;

public class Student extends Person{
	private String facultyNumber;
	private int lectureCount;
	private int exerciseCount;

	public Student(String name, String lastName, String facultyNumber, int lectureCount, int exerciseCount) {
		super(name, lastName);
		this.facultyNumber = facultyNumber;
		this.lectureCount = lectureCount;
		this.exerciseCount = exerciseCount;
	}
	
	public static boolean checkInputFacultyNumber(String input) {
		if (input.length() >= 5 && input.length() <= 10) {
			return true;
		} else {
			System.out.println("Expected length for faculty number is between 5 and 10 symbols.");
			return false;
		}
	}
	
	public static boolean checkStudentInput(String name, String lastName, String facultyNumber, String lectureCount, String exerciseCount) {
		return inputNameCheck(name) && inputNameCheck(lastName) && checkInputFacultyNumber(facultyNumber) &&
				checkHoursCount(lectureCount) && checkHoursCount(exerciseCount);
	}

	public double getAvgHoursPerDay() {
		return (this.lectureCount * 2 + this.exerciseCount * 1.5) / 5;
	}
	
	public void getInfo() {
		super.printNames();
		System.out.println("Student");
		System.out.println("Faculty number: "+ this.facultyNumber);
		System.out.printf("Hours per day: %.2f\n", this.getAvgHoursPerDay());
		System.out.println();
	}
	
	public String getFacultyNumber() {
		return facultyNumber;
	}

	public void setFacultyNumber(String facultyNumber) {
		this.facultyNumber = facultyNumber;
	}

	public int getLectureCount() {
		return lectureCount;
	}

	public void setLectureCount(int lectureCount) {
		this.lectureCount = lectureCount;
	}

	public int getExerciseCount() {
		return exerciseCount;
	}

	public void setExerciseCount(int exerciseCount) {
		this.exerciseCount = exerciseCount;
	}
	
}
