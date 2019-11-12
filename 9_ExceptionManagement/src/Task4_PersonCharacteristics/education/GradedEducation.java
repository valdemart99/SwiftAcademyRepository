package Task4_PersonCharacteristics.education;

import java.time.LocalDate;

import Task4_PersonCharacteristics.exceptions.IncorrectUserInputException;

public abstract class GradedEducation extends Education {
	private float finalGrade;
	
	public GradedEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName,
			float... finalGrade) throws Exception {
		super(enrollmentDate, graduationDate, institutionName);
		if (finalGrade.length > 0) {
			if (finalGrade[0] < 2 || finalGrade[0] > 6) {
				throw new IncorrectUserInputException("Graduation grade is expected to be between 2 and 6.");
			}
			this.finalGrade = finalGrade[0];
		}
	}

	public float getFinalGrade() throws Exception {
		if (this.isGraduated()) {
			return finalGrade;
		} else {
			throw new IncorrectUserInputException("No final grade can be provided before graduation.");
		}
		
	}
	
	public void gotGraduated(float finalGrade) throws Exception {
		if (finalGrade < 2 || finalGrade > 6) {
			throw new IncorrectUserInputException("Graduation grade is expected to be between 2 and 6.");
		}
		this.finalGrade = finalGrade;
	}
	
}
