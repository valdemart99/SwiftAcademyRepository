package Task4_PersonCharacteristics.education;

import java.time.LocalDate;

public abstract class Education {
	
	private boolean graduated;
	private LocalDate enrollmentDate;
	private LocalDate graduationDate;
	private String institutionName;
	
	public Education(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName) {
		this.enrollmentDate = enrollmentDate;
		this.graduationDate = graduationDate;
		this.institutionName = institutionName;
		this.graduated = graduationDate.isBefore(LocalDate.now()) ? true : false;
	}

	public abstract String getDegree();
	public abstract void gotGraduated();
	
	public boolean isGraduated() {
		return graduated;
	}
	
	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}
	
	public LocalDate getGraduationDate() {
		return graduationDate;
	}
	
	public String getInstitutionName() {
		return institutionName;
	}
	
	public void setGraduationDate(LocalDate graduationDate) {
		this.graduationDate = graduationDate;
		this.graduated = graduationDate.isBefore(LocalDate.now()) ? true : false;
	}
}
