package personchartask;
import java.util.*;

public class Task4_PersonCharacteristics {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter how many persons data will be processed: ");
		int count = sc.nextInt();
		sc.nextLine();
		Person[] list = new Person[count];
		
		for (int i = 0; i < count; ++i) {
			String[] tempArr = sc.nextLine().split(", ");
			
			float[] tempMarks = { Float.valueOf(tempArr[7]), Float.valueOf(tempArr[8]),
					Float.valueOf(tempArr[9]), Float.valueOf(tempArr[10]) };
			
			list[i] = new Person(tempArr[0], tempArr[1], tempArr[2].charAt(0), Short.valueOf(tempArr[3]),
						Float.valueOf(tempArr[4]), Short.valueOf(tempArr[5]), tempArr[6], tempMarks);
		}
		
		sc.close();
		
		for (int j = 0; j < count; ++j) {
			//Ivan Ivanov is 17 years old. He was born in 1999. His weight is 67.1 and he is 177 cm tall.
			//He is a Student with an average grade of 5.438. Ivan Ivanov is under-aged.
			System.out.printf("%s %s is %d years old. %s was born in %d. %s is %.1f and %s is %d tall. "
					+ "%s is a %s with an average grade of %.3f.", list[j].getFirstName(),
					list[j].getLastName(), 2019 - list[j].getBirth_year(), list[j].getGender() == 'M' ? "He": "She",
					list[j].getBirth_year(), list[j].getGender() == 'M' ? "His": "Her", list[j].getWeight(),
					list[j].getGender() == 'M' ? "he": "she", list[j].getHeight(),
					list[j].getGender() == 'M' ? "He": "She", list[j].getProfession(), list[j].getAvgMarks());
			
			if (2019 - list[j].getBirth_year() < 18) {
				System.out.printf(" %s %s is under-aged.", list[j].getFirstName(), list[j].getLastName());
			}
			System.out.println();
		}
		
	}
	
}

class Person {
	private String firstName;
	private String lastName;
	private char gender;
	private short birth_year;
	private float weight;
	private short height;
	private String profession;
	private float[] marks;
	
	public Person(String firstName, String lastName, char gender, short birth_year,
			float weight, short height,	String profession, float[] marks) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birth_year = birth_year;
		this.weight = weight;
		this.height = height;
		this.profession = profession;
		this.marks = marks;
	}
	
	public float getAvgMarks() {
		float result = 0;
		for (float x: this.marks) {
			result += x;
		}
		return result / this.marks.length;
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

	public short getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(short birth_year) {
		this.birth_year = birth_year;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public short getHeight() {
		return height;
	}

	public void setHeight(short height) {
		this.height = height;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public float[] getMarks() {
		return marks;
	}

	public void setMarks(float[] marks) {
		this.marks = marks;
	}
}