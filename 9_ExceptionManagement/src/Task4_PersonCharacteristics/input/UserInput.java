package Task4_PersonCharacteristics.input;

import java.time.*;
import java.time.format.*;
import java.util.*;

import Task4_PersonCharacteristics.*;
import Task4_PersonCharacteristics.education.*;

public class UserInput {
	private String[] commandLine;
	
	private String firstName, middleName, lastName;
	private char gender;
	private LocalDate birthDate;
	private short height;
	
	private String country, city, municipality, street;
	private short postalCode, number, floor, apartmentNo;
	
	private LocalDate enrollmentDate, graduationDate;
	private String institutionName;
	
	private float finalGrade;
	private char educationDegree;
	
	public UserInput(String commandInput) {
		this.commandLine = commandInput.split(";");

		this.firstName = commandLine[0];
		this.middleName = commandLine[1];
		this.lastName = commandLine[2];
		this.gender = commandLine[3].charAt(0);
		this.birthDate = LocalDate.parse(commandLine[4], DateTimeFormatter.ofPattern("d.M.yyyy"));
		this.height = Short.parseShort(commandLine[5]);
		
		this.country = commandLine[6];
		this.city = commandLine[7];
		this.municipality = commandLine[8];
		this.postalCode = Short.parseShort(commandLine[9]);
		this.street = commandLine[10];
		this.number = Short.parseShort(commandLine[11]);
		this.floor = commandLine[12].equals("") ? -1 : Short.parseShort(commandLine[12]);
		this.apartmentNo = commandLine[13].equals("") ? -1 : Short.parseShort(commandLine[13]);
		
		this.educationDegree = commandLine[14].charAt(0);
		this.institutionName = commandLine[15];
		this.enrollmentDate = LocalDate.parse(commandLine[16], DateTimeFormatter.ofPattern("d.M.yyyy"));
		this.graduationDate = LocalDate.parse(commandLine[17], DateTimeFormatter.ofPattern("d.M.yyyy"));
		this.finalGrade = commandLine.length == 19 ? Float.parseFloat(commandLine[18]) : -1f;
	}
	
	public String[] getCommandLine() {
		return commandLine;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public char getGender() {
		return gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public short getHeight() {
		return height;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getMunicipality() {
		return municipality;
	}

	public String getStreet() {
		return street;
	}

	public short getPostalCode() {
		return postalCode;
	}

	public short getNumber() {
		return number;
	}

	public short getFloor() {
		return floor;
	}

	public short getApartmentNo() {
		return apartmentNo;
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

	public float getFinalGrade() {
		return finalGrade;
	}

	public char getEducationDegree() {
		return educationDegree;
	}
}
