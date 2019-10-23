package Task4_PersonCharacteristics.education;

import java.time.LocalDate;

public class SecondaryEducation extends GradedEducation{

	public SecondaryEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName,
			float finalGrade) {
		super(enrollmentDate, graduationDate, institutionName, finalGrade);
	}
	
	public SecondaryEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName) {
		super(enrollmentDate, graduationDate, institutionName);
	}

	@Override
	public String getDegree() {
		return "secondary";
	}

	@Override
	public void gotGraduated() {}
}

