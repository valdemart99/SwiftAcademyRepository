package Task4_PersonCharacteristics.education;

import java.time.LocalDate;

public class HigherEducation extends GradedEducation{
	private char educationDegree;
	
	public HigherEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName,
			char educationDegree, float finalGrade) {
		super(enrollmentDate, graduationDate, institutionName, finalGrade);
		this.educationDegree = educationDegree;
	}
	
	public HigherEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName,
			char educationDegree) {
		super(enrollmentDate, graduationDate, institutionName);
		this.educationDegree = educationDegree;
	}

	@Override
	public String getDegree() {
		switch (this.educationDegree) {
			case 'B': return "bachelor";
			case 'M': return "master";
			case 'D': return "doctorate";
			default: return "private";
		}
	}

	@Override
	public void gotGraduated() {}
}
