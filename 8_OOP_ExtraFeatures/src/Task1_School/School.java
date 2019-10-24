package Task1_School;

public class School {
	private Class[] classes;
	
	public School(Class[] classes) {
		this.classes = classes;
	}
	
	public School() {
		this.classes = new Class[1000];
	}

	public Class[] getClasses() {
		return classes;
	}

	public void setClasses(Class[] classes) {
		this.classes = classes;
	}
	
	public String getRomanNumeral(int r) {
		switch (r ) {
			case 1: return "I";
			case 2: return "II";
			case 3: return "III";
			case 4: return "IV";
			case 5: return "V";
			case 6: return "VI";
			case 7: return "VII";
			case 8: return "VIII";
			case 9: return "IX";
			case 10: return "X";
			case 11: return "XI";
			case 12: return "XII";
			default: return "extra";
		}
	}
	
	public String getClassLetter(int b) {
		switch(b) {
		case 1: return "a";
		case 2: return "b";
		case 3: return "c";
		case 4: return "d";
		case 5: return "e";
		default: return "";
		}
	}
}
