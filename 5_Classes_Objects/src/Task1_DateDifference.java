import java.time.*;
import java.util.*;

public class Task1_DateDifference {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input1 = sc.nextLine().split(" ");
		String[] input2 = sc.nextLine().split(" ");
		SwiftDate firstDate = new SwiftDate(input1[0], input1[1], input1[2]);
		SwiftDate secondDate = new SwiftDate(input2[0], input2[1], input2[2]);		
		
		System.out.println(firstDate.getDaysDifference(secondDate));
		firstDate.printInfo();
		secondDate.printInfo();
		sc.close();
	}
	
}

class SwiftDate {
	private String year;
	private String month;
	private String day;
	
	public SwiftDate(String year, String month, String day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	boolean isLeapYear() {
		return ((Short.valueOf(this.year) % 4 == 0) && (Short.valueOf(this.year) % 100 != 0)) || 
				((Short.valueOf(this.year) % 100 == 0) && (Short.valueOf(this.year) % 400 == 0));
	}
	
	int getCentury() {
		return (Short.valueOf(this.year) / 100) + 1;
	}
	
	int getDaysDifference(SwiftDate other) {
		LocalDate firstDate = LocalDate.of(Integer.valueOf(this.year), 
				Integer.valueOf(this.month), Integer.valueOf(this.day));
		LocalDate secondDate = LocalDate.of(Integer.valueOf(other.year), 
				Integer.valueOf(other.month), Integer.valueOf(other.day));
		long proba = Period.between(firstDate, secondDate).getDays();
	    return Math.abs(Period.between(firstDate, secondDate).getDays());
//		return(Short.valueOf(this.year) * 365 + Short.valueOf(this.month) * 30 + Short.valueOf(this.day)) -
//				(Short.valueOf(other.year) * 365 + Short.valueOf(other.month) * 30 + Short.valueOf(other.day));
	}
	
	void printInfo() {
		System.out.format("%s %s %s - %d century.", this.year, this.month, this.day, this.getCentury());
		System.out.println(this.isLeapYear() ? " It is LEAP year." : "");
	}
}