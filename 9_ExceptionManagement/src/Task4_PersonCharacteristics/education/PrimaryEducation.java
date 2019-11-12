package Task4_PersonCharacteristics.education;

import java.time.LocalDate;

public class PrimaryEducation extends Education {

	public PrimaryEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName) throws Exception {
		super(enrollmentDate, graduationDate, institutionName);
	}

	@Override
	public String getDegree() {
		return "primary";
	}

	@Override
	public void gotGraduated() {}
}
