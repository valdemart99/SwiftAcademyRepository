package Task5_PersonCharacteristics;

import java.time.LocalDate;

public class SecondaryEducation {
	private double finalGrade;
	private boolean graduate;
	private final LocalDate enrollmentDate;
	private LocalDate graduationDate;
	private final String institutionName;
	
	public SecondaryEducation(LocalDate enrollmentDate,
			LocalDate graduationDate, String institutionName, double finalGrade) {
		this.enrollmentDate = enrollmentDate;
		this.graduationDate = graduationDate;
		this.institutionName = institutionName;
		this.finalGrade = finalGrade;
		this.graduate = true;
	}
	
	public SecondaryEducation(LocalDate enrollmentDate,
			LocalDate graduationDate, String institutionName) {
		this.finalGrade = -1;
		this.enrollmentDate = enrollmentDate;
		this.graduationDate = graduationDate;
		this.institutionName = institutionName;
		this.graduate = false;
	}
	
	public void setGraduationStatus(boolean graduate, double... finalGrade) {
		this.graduate = graduate;
		if (graduate) {
			this.finalGrade = finalGrade[0];
		} else {
			this.finalGrade = -1;
		}
	}

	public LocalDate getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(LocalDate graduationDate) {
		this.graduationDate = graduationDate;
	}

	public double getFinalGrade() {
		return finalGrade;
	}

	public boolean isGraduate() {
		return graduate;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public String getInstitutionName() {
		return institutionName;
	}
	
}
