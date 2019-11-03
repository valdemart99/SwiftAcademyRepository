package Task4_PersonCharacteristics.education;

import java.time.LocalDate;

public abstract class GradedEducation extends Education {
	private float finalGrade;
	
	public GradedEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName,
			float... finalGrade) {
		super(enrollmentDate, graduationDate, institutionName);
		if (finalGrade.length > 0) {
			this.finalGrade = finalGrade[0];
		}
	}

	public float getFinalGrade() {
		if (this.isGraduated()) {
			return finalGrade;
		} else {
			return -1;
		}
		
	}
	
	public void gotGraduated(float finalGrade) {
		this.finalGrade = finalGrade;
	}
	
}
