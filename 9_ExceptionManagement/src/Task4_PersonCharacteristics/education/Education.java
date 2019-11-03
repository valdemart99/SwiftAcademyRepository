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
	
	@Override
	public String toString() {
		//He started secondary degree in SOU Chintulov on 2015-09-16 and is supposed to graduate on 2020-05-22.
		//He started master degree in SU on 2005-10-04 and finished on 2007-05-15. His grade was 5.760.
		return String.format("He started %s degree in %s on %s and %s on %s.%s\n", 
				this.getDegree(),
				this.institutionName,
				this.enrollmentDate.toString(),
				(this.graduationDate.isBefore(LocalDate.now()) ? "finished" : "is supposed to graduate"),
				this.graduationDate.toString(),
				(this instanceof GradedEducation && this.graduationDate.isBefore(LocalDate.now()) ? 
						String.format(" His grade was %.3f", ((GradedEducation)this).getFinalGrade()) : ""));
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
	
	public void setGraduationDate(LocalDate graduationDate) {
		this.graduationDate = graduationDate;
		this.graduated = graduationDate.isBefore(LocalDate.now()) ? true : false;
	}
}
