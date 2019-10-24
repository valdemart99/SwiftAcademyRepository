package Task3_PersonCharacteristics;

import java.time.LocalDate;

import Task3_PersonCharacteristics.education.*;

public class PersonChar {
	private String firstName;
	private String middleName;
	private String lastName;
	private char gender;
	private LocalDate birth_date;
	private short height;
	private Education education;
	private Address address;
	
	public PersonChar(String firstName, String middleName, String lastName, char gender, LocalDate birth_date,
			short height, Address address, Education education) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.birth_date = birth_date;
		this.height = height;
		this.address = address;
		this.education = education;
	}
	
	public String toString() {
		return String.format("%s %s %s is %d years old. %s was born in %d.\n%s%s lives at: \n%s%s", 
				this.firstName,
				this.middleName,
				this.lastName,
				LocalDate.now().getYear() - this.birth_date.getYear(),
				(this.gender == 'M' ? "He" : "She"),
				this.birth_date.getYear(),
				(LocalDate.now().getYear() - this.birth_date.getYear() < 18 ? 
						String.format("%s %s is under-aged.\n", this.firstName, this.lastName) : ""),
				(this.gender == 'M' ? "He" : "She"),
				this.address.toString(),
				(this.gender == 'M' ? this.education.toString() : this.education.toString().replace("He", "She").replace("His", "Her")));
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setBirth_date(LocalDate birth_date) {
		this.birth_date = birth_date;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}
}

