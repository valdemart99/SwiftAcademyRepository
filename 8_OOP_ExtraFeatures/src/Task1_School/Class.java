package Task1_School;

public class Class {
	private String name;
	private Student[] students;
	private Teacher[] teachers;
	
	public Class(String name, Student[] students, Teacher[] teachers) {
		this.name = name;
		this.students = students;
		this.teachers = teachers;
	}
	
	public Class(String name, Student[] students) {
		this.name = name;
		this.students = students;
		this.teachers = new Teacher[25];
	}
	
	public Class(String name) {
		this.name = name;
		this.students = new Student[50];
		this.teachers = new Teacher[25];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public Teacher[] getTeachers() {
		return teachers;
	}

	public void setTeachers(Teacher[] teachers) {
		this.teachers = teachers;
	}
}
