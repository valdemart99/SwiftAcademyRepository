package Task4_PersonCharacteristics.education;

import java.time.LocalDate;

import Task4_PersonCharacteristics.exceptions.IncorrectUserInputException;

public abstract class Education {
	
	private boolean graduated;
	private LocalDate enrollmentDate;
	private LocalDate graduationDate;
	private String institutionName;
	
	public Education(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName) throws Exception {
		if (enrollmentDate.isAfter(graduationDate)) {
			throw new IncorrectUserInputException("Graduation date is expected to be after enrollment date.");
		}
		
		this.enrollmentDate = enrollmentDate;
		this.graduationDate = graduationDate;
		this.institutionName = institutionName;
		if (institutionName.isEmpty()) {
			throw new IncorrectUserInputException("Expected non-empty institution name.");
		}
		this.graduated = graduationDate.isBefore(LocalDate.now()) ? true : false;
	}

	public abstract String getDegree();
	public abstract void gotGraduated();
	
	@Override
	public String toString() {
		try {
			return String.format("He started %s degree in %s on %s and %s on %s.%s\n", 
				this.getDegree(),
				this.institutionName,
				this.enrollmentDate.toString(),
				(this.graduationDate.isBefore(LocalDate.now()) ? "finished" : "is supposed to graduate"),
				this.graduationDate.toString(),
				(this instanceof GradedEducation && this.graduationDate.isBefore(LocalDate.now()) ? 
						String.format(" His grade was %.3f", ((GradedEducation)this).getFinalGrade()) : ""));
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
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
	
	public void setGraduationDate(LocalDate graduationDate) throws Exception {
		if (graduationDate.isAfter(LocalDate.now())) {
			throw new IncorrectUserInputException("Graduation date is expected to be a date in the past.");
		}
		this.graduationDate = graduationDate;
		this.graduated = graduationDate.isBefore(LocalDate.now()) ? true : false;
	}
}
