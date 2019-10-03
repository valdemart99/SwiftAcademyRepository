
public class Task2_LeapYear {

	public static void main(String[] args) {
		short year;
		// The logic is that an year is leap either when:
		// 1. it can be divided by 4 and is not divisible by 100
		// 2. it is divisible by 100 and by 400
		
		year = 2016;
		System.out.println(year);
		System.out.println(((year % 4 == 0) && (year % 100 != 0)) || ((year % 100 == 0) && (year % 400 == 0)));
		
		year = 1992;
		System.out.println(year);
		System.out.println(((year % 4 == 0) && (year % 100 != 0)) || ((year % 100 == 0) && (year % 400 == 0)));
		
		year = 2001;
		System.out.println(year);
		System.out.println(((year % 4 == 0) && (year % 100 != 0)) || ((year % 100 == 0) && (year % 400 == 0)));
		
		year = 1900;
		System.out.println(year);
		System.out.println(((year % 4 == 0) && (year % 100 != 0)) || ((year % 100 == 0) && (year % 400 == 0)));
		
		year = 2400;
		System.out.println(year);
		System.out.println(((year % 4 == 0) && (year % 100 != 0)) || ((year % 100 == 0) && (year % 400 == 0)));

	}
	
}
