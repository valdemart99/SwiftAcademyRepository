package Task1_School;

import java.util.Dictionary;

public class Demo {
	
	
	public static void main(String[] args) {
		School neofitRilski = new School();
		Class[] klasove = new Class[40];
		neofitRilski.setClasses(klasove);
		
		for (int i = 0; i < klasove.length; ++i) {
			klasove[i] = new Class(neofitRilski.getRomanNumeral((i / 5) + 1) + neofitRilski.getClassLetter((i % 5) + 1));
		}
		
		Student petyr = new Student("Petyr", (short) 15);
		Student todor = new Student("Todor", (short) 20);
		Student katya = new Student("Katya", (short) 12);
		Student[] paralelka = { petyr, todor, katya };
		
		Discipline geography = new Discipline("Geografiq", (short) 3);
		Discipline history = new Discipline("Istoriq", (short) 3);
		Discipline math = new Discipline("Matematika", (short) 6);
		Discipline language = new Discipline("Bylgarski ezik", (short) 6);
		Discipline[] prirodoznanie = { geography, history };
		Discipline[] technicheskiNauki = { math };
		
		Teacher stoimenov = new Teacher("Stoimenov", prirodoznanie);
		Teacher aleksandrova = new Teacher("Aleksandrova", technicheskiNauki);
		Teacher[] prepodavateli = { stoimenov, aleksandrova };
		
		klasove[12].setStudents(paralelka);
		klasove[12].setTeachers(prepodavateli);
		
		System.out.println(klasove[12].getName() + " klas:");
		for (Teacher t: klasove[12].getTeachers()) {
			if (t != null) {
				System.out.println("Teacher: " + t.getName() + ", Osnoven predmet: " +
						t.getDisciplines()[0].getName() + " - " + t.getDisciplines()[0].getHoursPerWeek() + " chasa sedmichno");
			}
		}

		for (Student s: klasove[12].getStudents()) {
			if (s != null) {
				System.out.println(s.getName() + ", Nomer v klasa: " + s.getIdNumber());
			}
		}
	}
}
