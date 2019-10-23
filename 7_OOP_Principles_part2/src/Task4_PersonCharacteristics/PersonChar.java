package Task4_PersonCharacteristics;

import java.time.LocalDate;

import Task4_PersonCharacteristics.education.*;

public class PersonChar {
	private String firstName;
	private String lastName;
	private char gender;
	private LocalDate birth_date;
	private short height;
	private Education education;
	
	public PersonChar(String firstName, String lastName, char gender, LocalDate birth_date,
			short height, Education education) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birth_date = birth_date;
		this.height = height;
		this.education = education;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public LocalDate getBirth_date() {
		return birth_date;
	}

	public void setBirth_year(LocalDate birth_date) {
		this.birth_date = birth_date;
	}

	public short getHeight() {
		return height;
	}

	public void setHeight(short height) {
		this.height = height;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}
}

