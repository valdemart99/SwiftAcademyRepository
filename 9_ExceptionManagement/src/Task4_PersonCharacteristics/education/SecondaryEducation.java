package Task4_PersonCharacteristics.education;

import java.time.LocalDate;

public class SecondaryEducation extends GradedEducation{

	public SecondaryEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName,
			float finalGrade) throws Exception {
		super(enrollmentDate, graduationDate, institutionName, finalGrade);
	}
	
	public SecondaryEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName) throws Exception {
		super(enrollmentDate, graduationDate, institutionName);
	}

	@Override
	public String getDegree() {
		return "secondary";
	}

	@Override
	public void gotGraduated() {}
}

